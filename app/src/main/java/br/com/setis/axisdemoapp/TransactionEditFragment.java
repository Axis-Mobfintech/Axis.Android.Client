package br.com.setis.axisdemoapp;

import android.location.Location;
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

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;
import br.com.setis.axisdemoapp.data.Geolocation;
import br.com.setis.axisdemoapp.room.ValidadorDatabase;
import br.com.setis.axisdemoapp.room.ValidadorInfo;
import br.com.setis.axisdemoapp.viewmodel.ValidadorViewModel;

import static androidx.fragment.app.FragmentManager.POP_BACK_STACK_INCLUSIVE;

public class TransactionEditFragment extends Fragment {

    private ExecutorService executor;
    private Handler handler;
    private ValidadorDatabase db;
    private ValidadorInfo info;
    private EditText amount;
    private EditText geolocation;
    private Location location;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.transaction_edit_fragment, container, false);

        ImageView menuBtn = view.findViewById(R.id.menu_btn);
        menuBtn.setOnClickListener(v -> backToMenu());

        Button saveBtn = view.findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(v -> saveInfo());

        amount = view.findViewById(R.id.ticket_amount);
        geolocation = view.findViewById(R.id.geolocation);

        executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            db = Room.databaseBuilder(Objects.requireNonNull(getContext()), ValidadorDatabase.class, "database-validador").build();
            info = db.validadorInfoDAO().getInfo();

            String amountText, geolocationText;
            if (info == null || info.valor == 0) {
                amountText = String.format(Locale.getDefault(), "%.2f", ValidadorViewModel.Valor / 100d);
                geolocationText = ValidadorViewModel.Geolocalizacao;
            } else {
                amountText = String.format(Locale.getDefault(), "%.2f", info.valor / 100d);
                geolocationText = info.geoValidador;
            }

            location = Geolocation.getLocation(Objects.requireNonNull(getActivity()));
            if (location != null) {
                geolocationText = String.format(Locale.ENGLISH, "%f, %f", location.getLatitude(), location.getLongitude());
            }

            amount.setText(amountText);
            geolocation.setText(geolocationText);
        });

        handler = new Handler(Looper.getMainLooper());

        view.setFocusableInTouchMode(true);
        view.requestFocus();

        view.setOnKeyListener((v, keyCode, event) -> {
            if (event.getAction() != KeyEvent.ACTION_DOWN)
                return false;
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                back();
                return true;
            }
            return false;
        });

        return view;
    }

    private void backToMenu() {
        executor.execute(() -> {
            handler.post(() -> Toast.makeText(getActivity(), "Retornando ao menu. Aguarde.", Toast.LENGTH_LONG).show());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            handler.post(() -> getParentFragmentManager().popBackStackImmediate("menu", POP_BACK_STACK_INCLUSIVE));
        });
    }

    private void back() {
        getParentFragmentManager().popBackStackImmediate();
    }

    private void saveInfo() {
        Toast.makeText(getActivity(), "Salvando dados. Aguarde.", Toast.LENGTH_SHORT).show();

        executor.execute(() -> {
            if (info == null) info = new ValidadorInfo();

            info.valor = (int) (Double.parseDouble(amount.getText().toString().replaceAll(",", ".")) * 100);
            info.geoValidador = geolocation.getText().toString();

            db.validadorInfoDAO().deleteAll();
            db.validadorInfoDAO().insertBaseValues(info);

            handler.post(() -> Toast.makeText(getActivity(), "Dados salvos com sucesso", Toast.LENGTH_SHORT).show());
        });
    }
}
