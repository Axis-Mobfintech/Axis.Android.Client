package br.com.setis.axisdemoapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;
import br.com.setis.axisdemoapp.room.ValidadorDatabase;
import br.com.setis.axisdemoapp.room.ValidadorInfo;
import br.com.setis.axisdemoapp.viewmodel.ValidadorViewModel;

public class DeviceEditFragment extends Fragment {

    private ExecutorService executor;
    private Handler handler;
    private ValidadorDatabase db;
    private ValidadorInfo info;
    private EditText enterpriseId;
    private EditText deviceSerialNumber;
    private EditText lineId;
    private EditText vehicleId;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.device_edit_fragment, container, false);

        ImageView menuBtn = view.findViewById(R.id.menu_btn);
        menuBtn.setOnClickListener(v -> backToMenu());

        Button saveBtn = view.findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(v -> saveInfo());

        Button nextBtn = view.findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(v -> goToNext());

        enterpriseId = view.findViewById(R.id.enterprise_id);
        deviceSerialNumber = view.findViewById(R.id.device_sn);
        lineId = view.findViewById(R.id.line_id);
        vehicleId = view.findViewById(R.id.vehicle_id);

        executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            db = Room.databaseBuilder(Objects.requireNonNull(getContext()), ValidadorDatabase.class, "database-validador").build();
            info = db.validadorInfoDAO().getInfo();
            if (info == null || info.nsValidador == null) {
                enterpriseId.setText(ValidadorViewModel.IdOperador);
                deviceSerialNumber.setText(ValidadorViewModel.NsValidador);
                lineId.setText(ValidadorViewModel.IdLinha);
                vehicleId.setText(ValidadorViewModel.IdVeiculo);

            } else {
                enterpriseId.setText(info.idOperador);
                deviceSerialNumber.setText(info.nsValidador);
                lineId.setText(info.idLinha);
                vehicleId.setText(info.idVeiculo);
            }
        });

        handler = new Handler(Looper.getMainLooper());

        view.setFocusableInTouchMode(true);
        view.requestFocus();

        view.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() != KeyEvent.ACTION_DOWN)
                return false;
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                backToMenu();
                return true;
            }
            return false;
        });

        return view;
    }

    private void goToNext() {
        executor.execute(() -> {
            FragmentManager fragmentManager = Objects.requireNonNull(getActivity()).getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            TransactionEditFragment edit = new TransactionEditFragment();
            transaction.replace(R.id.fragment_container, edit);

            transaction.addToBackStack("edit");
            transaction.commit();
        });
    }

    private void backToMenu() {
        executor.execute(() -> {
            handler.post(() -> Toast.makeText(getActivity(), "Retornando ao menu. Aguarde.", Toast.LENGTH_LONG).show());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(() -> getParentFragmentManager().popBackStackImmediate());
        });
    }

    private void saveInfo() {
        Toast.makeText(getActivity(), "Salvando dados. Aguarde.", Toast.LENGTH_SHORT).show();

        executor.execute(() -> {
            if (info == null) info = new ValidadorInfo();

            info.idOperador = enterpriseId.getText().toString();
            info.nsValidador = deviceSerialNumber.getText().toString();
            info.idLinha = lineId.getText().toString();
            info.idVeiculo = vehicleId.getText().toString();

            db.validadorInfoDAO().deleteAll();
            db.validadorInfoDAO().insertBaseValues(info);

            handler.post(() -> Toast.makeText(getActivity(), "Dados salvos com sucesso", Toast.LENGTH_SHORT).show());
        });
    }
}
