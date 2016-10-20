package es.ujaen.git.practica1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ServicioRemotoActivity extends AppCompatActivity {
    TextView user, pass, port, ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String muser, mpass, mip;
        int mport;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicio_remoto);
        user = (TextView) findViewById(R.id.servicio_remoto_user_textview);
        pass = (TextView) findViewById(R.id.servicio_remoto_pass_textview);
        port = (TextView) findViewById(R.id.servicio_remoto_port_textview);
        ip = (TextView) findViewById(R.id.servicio_remoto_ip_textview);
        muser = getIntent().getStringExtra("user");
        mpass = getIntent().getStringExtra("pass");
        mport = getIntent().getIntExtra("port", 4);
        mip = getIntent().getStringExtra("ip");
    }
}
