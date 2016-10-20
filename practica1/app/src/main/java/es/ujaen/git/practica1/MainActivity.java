package es.ujaen.git.practica1;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    Button boton_enviar;
    EditText user, pass, port, ip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentActivity = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentActivity.beginTransaction();

        AuthFragment authFragment = new AuthFragment();
        fragmentTransaction.add(R.id.fragment, authFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}


