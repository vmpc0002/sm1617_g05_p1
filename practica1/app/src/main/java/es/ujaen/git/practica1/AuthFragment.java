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
                Authentication authentication = new Authentication(user.getText().toString(), pass.getText().toString(), ip.getText().toString(), 0);

                Toast.makeText(fragmento.getContext(), authentication.getUser(), Toast.LENGTH_SHORT).show();
               /* Intent intent_sercicioremoto = new Intent(fragmento.getContext(), ServicioRemotoActivity.class);
                intent_sercicioremoto.putExtra("user", authentication.getUser());
                intent_sercicioremoto.putExtra("pass", authentication.getPass());
                intent_sercicioremoto.putExtra("port", authentication.getPort());
                intent_sercicioremoto.putExtra("ip", authentication.getIP());
                startActivity(intent_sercicioremoto);*/
            }
        });
        return fragmento;
    }


}
