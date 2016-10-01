package es.ujaen.git.practica1;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentActivity = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentActivity.beginTransaction();

        AuthFragment authFragment = new AuthFragment();
        fragmentTransaction.add(R.id.main_container, authFragment);
    }

}


