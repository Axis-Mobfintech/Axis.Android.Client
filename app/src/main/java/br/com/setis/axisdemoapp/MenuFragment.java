package br.com.setis.axisdemoapp;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import br.com.setis.axisdemoapp.viewmodel.ValidadorViewModel;

public class MenuFragment extends Fragment {

    private ValidadorViewModel validadorViewModel;

    private LinearLayout registroBtn;
    private LinearLayout obterParamBtn;
    private LinearLayout obterListaExcBtn;
    private LinearLayout passagemBtn;
    private LinearLayout recuperarDebBtn;
    private LinearLayout conectarLeitorBtn;
    private LinearLayout testarComunicacaoBtn;

    private TextView logsTv;
    private TextView statusTv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.menu_fragment, container, false);

        registroBtn = view.findViewById(R.id.registrarBtn);
        obterParamBtn = view.findViewById(R.id.paramBtn);
        obterListaExcBtn = view.findViewById(R.id.listaExcBtn);
        passagemBtn = view.findViewById(R.id.passagemBtn);
        recuperarDebBtn = view.findViewById(R.id.recuperarDebBtn);
        conectarLeitorBtn = view.findViewById(R.id.conectarLeitorBtn);
        testarComunicacaoBtn = view.findViewById(R.id.testarComunicacaoBtn);

        logsTv = view.findViewById(R.id.logTextview);
        statusTv = view.findViewById(R.id.statusTextview);

        ViewModelProvider.Factory factory = new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new ValidadorViewModel(getActivity());
            }
        };
        validadorViewModel = new ViewModelProvider(requireActivity(), factory).get(ValidadorViewModel.class);
        if (validadorViewModel.obterStatusLeitor()) {
            statusTv.setText("Status do Leitor: Conectado.");
        }

        registroBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logsTv.setText("Processando...");
                validadorViewModel.registrarValidador();
            }
        });

        obterParamBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logsTv.setText("Processando...");
                validadorViewModel.obterParametro();
            }
        });

        obterListaExcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logsTv.setText("Processando...");
                validadorViewModel.obterListaExcecao();
            }
        });

        passagemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verifica se o leitor esta conectado.
                //if (validadorViewModel.getFirmwareVersion().length() > 0) {
                    ExecutorService executor = Executors.newSingleThreadExecutor();
                    executor.execute(new Runnable() {
                        @Override
                        public void run() {
                            if (validadorViewModel.verificaRegistro()) {
                                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                                FragmentTransaction transaction = fragmentManager.beginTransaction();

                                MastercardPassageFragment master = new MastercardPassageFragment();
                                transaction.replace(R.id.fragment_container, master);

                                //PassageFragment passage = new PassageFragment();
                                //transaction.replace(R.id.fragment_container, passage);
                                transaction.addToBackStack("menu");
                                transaction.commit();
                            }
                        }
                    });
                //} else {
                //    validadorViewModel.displayLog("Erro: Leitor nao encontrado.");
                //}
            }
        });

        recuperarDebBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validadorViewModel.recuperarDebito();
                Toast.makeText(getActivity(), "TODO", Toast.LENGTH_SHORT).show();
            }
        });

        conectarLeitorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validadorViewModel.reconectarLeitor();
                if (validadorViewModel.obterStatusLeitor()) {
                    statusTv.setText("Status do Leitor: Conectado.");
                    Toast.makeText(getActivity(), "LEITOR CONECTADO.", Toast.LENGTH_SHORT).show();
                } else {
                    statusTv.setText("Status do Leitor: Desconectado.");
                    Toast.makeText(getActivity(), "LEITOR NAO ENCONTRADO.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        testarComunicacaoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validadorViewModel.commTest();
            }
        });

        final Observer<String> obs = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String msg) {
                // Update the UI, in this case, a TextView.
                logsTv.setText(msg);
            }
        };
        validadorViewModel.getLiveData().observe(getViewLifecycleOwner(), obs);


        final Observer<String> obs1 = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String msg) {
                // Update the UI, in this case, a TextView.
                logsTv.setText(msg);
                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
            }
        };
        validadorViewModel.getSimulaData().observe(getViewLifecycleOwner(), obs1);

        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener( new View.OnKeyListener()
        {
            @Override
            public boolean onKey( View v, int keyCode, KeyEvent event )
            {
                if( keyCode == KeyEvent.KEYCODE_BACK )
                {
                    getActivity().finish();
                    return true;
                }
                return false;
            }
        } );

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        validadorViewModel.reconectarLeitor();
    }
}
