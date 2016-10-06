package es.ujaen.git.practica1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class AuthFragment extends Fragment {

    EditText user, pass, port, ip;
    public AuthFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmento = inflater.inflate(R.layout.frag_authentication, container, false);
        Button boton_envio = (Button) fragmento.findViewById(R.id.autenticacion_envia_boton);
        user=(EditText) fragmento.findViewById(R.id.autenticacion_user_edittext);
        pass=(EditText) fragmento.findViewById(R.id.autenticacion_pass_edittext);
        port=(EditText) fragmento.findViewById(R.id.autenticacion_port_edittext);
        ip=(EditText) fragmento.findViewById(R.id.autenticacion_ip_edittext);
        boton_envio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_output = user.getText().toString();
                String pass_output = pass.getText().toString();
                String port_output = port.getText().toString();

            }
        });
        return fragmento;
    }


}
