package es.ujaen.git.practica1;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AuthFragment extends Fragment {

    EditText user, pass, port, ip;
    Button boton_envio;

    public AuthFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View fragmento = inflater.inflate(R.layout.frag_authentication, container, false);

        boton_envio = (Button) fragmento.findViewById(R.id.autenticacion_envia_boton);
        user = (EditText) fragmento.findViewById(R.id.autenticacion_user_edittext);
        pass = (EditText) fragmento.findViewById(R.id.autenticacion_pass_edittext);
        port = (EditText) fragmento.findViewById(R.id.autenticacion_port_edittext);
        ip = (EditText) fragmento.findViewById(R.id.autenticacion_ip_edittext);

        boton_envio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_output = user.getText().toString();
                String pass_output = pass.getText().toString();
                String port_output = port.getText().toString();
                String ip_output = port.getText().toString();
                Toast.makeText(fragmento.getContext(), "funciona", Toast.LENGTH_SHORT).show();
                Intent intent_sercicioremoto = new Intent(fragmento.getContext(), ServicioRemotoActivity.class);
                intent_sercicioremoto.putExtra("user", user_output);
                intent_sercicioremoto.putExtra("pass", pass_output);
                intent_sercicioremoto.putExtra("port", port_output);
                intent_sercicioremoto.putExtra("ip", ip_output);
                startActivity(intent_sercicioremoto);
            }
        });
        return fragmento;
    }


}
