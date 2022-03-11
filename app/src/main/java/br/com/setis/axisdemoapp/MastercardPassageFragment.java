package br.com.setis.axisdemoapp;

import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mastercard.sonic.controller.SonicController;
import com.mastercard.sonic.controller.SonicType;
import com.mastercard.sonic.listeners.OnCompleteListener;
import com.mastercard.sonic.listeners.OnPrepareListener;
import com.mastercard.sonic.widget.SonicView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import br.com.setis.axisdemoapp.viewmodel.ValidadorViewModel;

public class MastercardPassageFragment extends Fragment {

    private SonicController sonicController;
    private SonicView sonicView;
    private boolean isReady;

    private ValidadorViewModel validadorViewModel;
    private LinearLayout idle;
    private ConstraintLayout success;
    private ConstraintLayout failed;

    private TextView failedTv;
    private Handler handler;

    private ImageView menuBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mastercard_passage_fragment, container, false);
        isReady = false;
        sonicController = new SonicController();

        TextView versionTv = view.findViewById(R.id.version_tv);
        try {
            PackageInfo pInfo = getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 0);
            String version = pInfo.versionName;
            versionTv.setText(String.format("v%s", version));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        TextView dataTv = view.findViewById(R.id.data_tv);
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dataTv.setText(dateFormat.format(currentDate));

        menuBtn = view.findViewById(R.id.menu_btn);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAction();
            }
        });

        ViewModelProvider.Factory factory = new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new ValidadorViewModel(getActivity());
            }
        };
        validadorViewModel = new ViewModelProvider(requireActivity(), factory).get(ValidadorViewModel.class);
        handler = new Handler(Looper.getMainLooper());

        idle = view.findViewById(R.id.master_screen);
        success = view.findViewById(R.id.sonic_content);
        failed = view.findViewById(R.id.failed);
        //cancel = view.findViewById(R.id.cancel_btn);
        failedTv = view.findViewById(R.id.motivo_tv);

        validadorViewModel.clearLivedata();

        final Observer<String> obs = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String msg) {
                // Update the UI, in this case, a TextView.
                if (msg.toUpperCase().contains("APROVADA")) {
                    showSucess();
                }
                else if (msg.toUpperCase().contains("RECUSADA")) {
                    showFailed(msg);
                }
                else if (msg.toUpperCase().contains("TIMEOUT")) {
                    restart();
                }
            }
        };
        validadorViewModel.getTransactionLiveData().observe(getViewLifecycleOwner(), obs);

        validadorViewModel.registrarPassagem();

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {
                    cancelAction();
                    return true;
                }
                return false;
            }
        } );

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sonicView = view.findViewById(R.id.sonic_view);
        sonicController.prepare(getContext(), SonicType.ANIMATION_ONLY, new OnPrepareListener() {
            @Override
            public void onPrepared(int i) {
                Log.d("AxisLog", "onPrepared finished: "+i);
                isReady = true;
            }
        });
    }

    private void showIdle() {
        Log.d("AxisLog", "show idle.");
        idle.setVisibility(View.VISIBLE);
        success.setVisibility(View.GONE);
        failed.setVisibility(View.GONE);
    }

    private void showSucess() {
        Log.d("AxisLog", "ShowSuccess");
        idle.setVisibility(View.GONE);
        success.setVisibility(View.VISIBLE);
        failed.setVisibility(View.GONE);
        playAnimation();
        restart();
    }

    private void showFailed(String what) {
        Log.d("AxisLog", "showFailed.");
        idle.setVisibility(View.GONE);
        success.setVisibility(View.GONE);
        failed.setVisibility(View.VISIBLE);
        failedTv.setText(what);
        restart();
    }

    private void restart() {
        Log.d("AxisLog", "restarting.");
        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                showIdle();
                validadorViewModel.registrarPassagem();
            }
        });
    }

    private void cancelAction() {
        Toast.makeText(getActivity(), "ENCERRANDO...", Toast.LENGTH_SHORT).show();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                validadorViewModel.cancelTransaction();
                backToMenu();
            }
        });

    }

    private void backToMenu() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                MenuFragment menu = new MenuFragment();
                transaction.replace(R.id.fragment_container, menu);
                transaction.commit();
                //fragmentManager.popBackStackImmediate();
            }
        });

    }

    private void playAnimation() {
        if (isReady && !sonicController.isPlaying()) {
            sonicController.play(new OnCompleteListener() {
                @Override
                public void onComplete(int i) {
                    Log.d("AxisLog", "onComplete :"+i);
                }
            }, sonicView);
        }
    }

}
