package br.com.setis.axisdemoapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import br.com.setis.axisdemoapp.viewmodel.ValidadorViewModel;

public class PassageFragment extends Fragment {

    private ValidadorViewModel validadorViewModel;
    private ConstraintLayout idle;
    private ConstraintLayout success;
    private ConstraintLayout failed;
    private LinearLayout cancel;
    private TextView failedTv;
    private Handler handler;

    private ProgressBar loading;
    private TextView idleTv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.passage_fragment, container, false);

        ViewModelProvider.Factory factory = new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new ValidadorViewModel(getActivity());
            }
        };
        validadorViewModel = new ViewModelProvider(requireActivity(), factory).get(ValidadorViewModel.class);
        handler = new Handler(Looper.getMainLooper());

        idle = view.findViewById(R.id.idle);
        success = view.findViewById(R.id.success);
        failed = view.findViewById(R.id.failed);
        cancel = view.findViewById(R.id.cancel_btn);
        failedTv = view.findViewById(R.id.motivo_tv);

        loading = view.findViewById(R.id.loading);
        idleTv = view.findViewById(R.id.idle_tv);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelAction();
            }
        });

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
                    //cancelAction();
                    return true;
                }
                return false;
            }
        } );

        return view;
    }

    private void showIdle() {
        idle.setVisibility(View.VISIBLE);
        success.setVisibility(View.GONE);
        failed.setVisibility(View.GONE);

        idleTv.setText("APROXIME\nUM\nCARTÃO");
        loading.setVisibility(View.GONE);
    }

    private void showSucess() {
        idle.setVisibility(View.GONE);
        success.setVisibility(View.VISIBLE);
        failed.setVisibility(View.GONE);
        restart();
    }

    private void showFailed(String what) {
        idle.setVisibility(View.GONE);
        success.setVisibility(View.GONE);
        failed.setVisibility(View.VISIBLE);
        failedTv.setText(what);
        restart();
    }

    private void restart() {
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
        idleTv.setText("ENCERRANDO...");
        loading.setVisibility(View.VISIBLE);
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
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStackImmediate();
            }
        });

    }


}
