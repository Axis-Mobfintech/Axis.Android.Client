package br.com.setis.axisdemoapp;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import br.com.setis.axisdemoapp.data.Geolocation;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        MenuFragment menu = new MenuFragment();
        transaction.add(R.id.fragment_container, menu);

        //MastercardPassageFragment master = new MastercardPassageFragment();
        //transaction.add(R.id.fragment_container, master);

        //PassageFragment passage = new PassageFragment();
        //transaction.add(R.id.fragment_container, passage);

        transaction.commit();

        Geolocation.init(this);
    }

}