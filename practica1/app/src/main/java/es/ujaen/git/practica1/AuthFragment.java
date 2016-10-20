package es.ujaen.git.practica1;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AuthFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";

    private String mUser = "";
    private String mPass = "";
    private String mIp = "";
    private String mPort = "";

    private EditText mEditUser = null;
    private EditText mEditPass = null;
    private EditText mEditPort = null;
    private EditText mEditIp = null;

    private Button boton_envio;
    private Authentication mAutentica = new Authentication("", "", "", 0);

    public AuthFragment() {

    }

    public static AuthFragment newInstance(String user, String pass, String ip, int port) {
        AuthFragment fragment = new AuthFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, user);
        args.putString(ARG_PARAM2, pass);
        args.putString(ARG_PARAM3, ip);
        args.putInt(ARG_PARAM4, port);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null)
            if (getArguments() != null) {
                mUser = getArguments().getString(ARG_PARAM1);
                mPass = getArguments().getString(ARG_PARAM2);
                mIp = getArguments().getString(ARG_PARAM3);
                mPort = getArguments().getString(ARG_PARAM4);
                mAutentica.setUser(mUser);
                mAutentica.setPass(mPass);
                mAutentica.setIP(mIp);
                try {
                    mAutentica.setPort(Integer.parseInt(mPort));
                } catch (NumberFormatException ex) {
                    mAutentica.setPort(0);
                }
            }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            Toast.makeText(getActivity(), "Cambio de configuración", Toast.LENGTH_SHORT).show();
            mAutentica.setUser(savedInstanceState.getString(ARG_PARAM1));
            mAutentica.setPass(savedInstanceState.getString(ARG_PARAM2));
            mAutentica.setIP(savedInstanceState.getString(ARG_PARAM3));
            mAutentica.setPort(Integer.parseInt(savedInstanceState.getString(ARG_PARAM4)));
        }
        View fragmento = inflater.inflate(R.layout.frag_authentication, container, false);

        reescribir(fragmento);

        boton_envio = (Button) fragmento.findViewById(R.id.autenticacion_envia_boton);
        boton_envio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extraer();
                Intent intent_sercicioremoto = new Intent(getActivity(), ServicioRemotoActivity.class);
                intent_sercicioremoto.putExtra("user", mAutentica.getUser());
                intent_sercicioremoto.putExtra("pass", mAutentica.getPass());
                intent_sercicioremoto.putExtra("port", mAutentica.getPort());
                intent_sercicioremoto.putExtra("ip", mAutentica.getIP());
                startActivity(intent_sercicioremoto);
            }
        });
        return fragmento;
    }

    private void extraer (){
        mAutentica.setUser(mEditUser.getText().toString());
        mAutentica.setPass(mEditPass.getText().toString());
        mAutentica.setIP(mEditPass.getText().toString());
        mAutentica.setPort(Integer.parseInt(mEditPort.getText().toString()));
    }

    private void reescribir (View container) {

        mEditUser = (EditText) container.findViewById(R.id.autenticacion_user_edittext);
        mEditPass = (EditText) container.findViewById(R.id.autenticacion_pass_edittext);
        mEditPort = (EditText) container.findViewById(R.id.autenticacion_port_edittext);
        mEditIp = (EditText) container.findViewById(R.id.autenticacion_ip_edittext);

        mEditUser.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                mAutentica.setUser(mEditUser.getText().toString());
            }
        });

        mEditPass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                mAutentica.setPass(mEditPass.getText().toString());
            }
        });

        mEditIp.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                mAutentica.setIP(mEditIp.getText().toString());
            }
        });

        mEditPort.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                try {
                    mAutentica.setPort(Integer.parseInt(mEditPort.getText().toString()));
                } catch (NumberFormatException ex) {
                    mAutentica.setPort(0);
                }
            }
        });

        mEditUser.setText(mAutentica.getUser());
        mEditPass.setText(mAutentica.getPass());
        mEditIp.setText(mAutentica.getIP());
        mEditPort.setText(Integer.toString(mAutentica.getPort()));
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(ARG_PARAM1, mAutentica.getUser());
        outState.putString(ARG_PARAM2, mAutentica.getPass());
        outState.putString(ARG_PARAM3, mAutentica.getIP());
        outState.putString(ARG_PARAM4, Integer.toString(mAutentica.getPort()));
    }
}
