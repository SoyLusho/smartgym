package com.smart.gym;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //publicidad
    InterstitialAd interstitialAd; // Publicidad pantalla completa
    AdView adView; //publicidad tipo Banner osea pequeñita
    //

    //arranque login
    private Button entrar;
    private TextInputLayout mEmailInput;
    private TextInputLayout contra;
    private String linea="",email="";

    private String[ ] datos = new  String[2];
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mEmailInput = (TextInputLayout) findViewById(R.id.correo);
        contra = (TextInputLayout) findViewById(R.id.password);
        entrar=(Button)findViewById(R.id.button1);
        entrar.setOnClickListener(this);


        //baner pequeño
        adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.id_publicidad_banner));
        adView.setAdSize(AdSize.BANNER);

        CardView cardView = (CardView) findViewById(R.id.banner_publicidad);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        adView.loadAd(adRequest2);
        cardView.addView(adView);//esto carga el baner pequeño enla interfaz

        //aqui va la de pantalla completa
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.id_publicidad_pantalla_completa));
        AdRequest adRequest1 = new AdRequest.Builder().build();
        interstitialAd.loadAd(adRequest);
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                interstitialAd.show();
            }
        });

    }

    @Override
    public void onClick(View v) {

        Thread tr=new Thread(){
            @Override
            public void run() {

                final Ping objeto = new Ping();
                email = mEmailInput.getEditText().getText().toString();


                if(email.equalsIgnoreCase("")){
                    email=linea;
                }

                datos[1]=email;

                final String contraseña = contra.getEditText().getText().toString();

                final String resultado = ENVIAR_DATOS_GET(email, contraseña);
                final String ping = objeto.Ping();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        int r=OBTENER_DATOS(resultado);

                        int internet = objeto.verificar_ping(ping);
                        if(r>0){
                            Crear_Session( );
                            Intent i=new Intent(getApplicationContext(),MenuActivity.class);
                            startActivity(i);
                            finish();


                        }else{

                            if(internet>0){
                                mensaje("Error","El correo o la contraseña son incorrectos");
                            }else{
                                mensaje("Error","Verificar Conexion a internet");
                            }



                        }



                    }
                });

            }
        };
        tr.start();


    }


    public void Crear_Session( ){
        SharedPreferences Session=getSharedPreferences("session_init", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Session.edit();

        editor.putBoolean("yes",true);
        editor.putString("nombre",datos[0]);
        editor.putString("correo",datos[1]);
        editor.commit();

    }

    public String ENVIAR_DATOS_GET(String correo, String contraseña){

        URL url = null;
        String linea="";
        int respuesta =0;
        //StringBuilder resul= null;
        String resul= "";


        try {
            url = new URL("https://comunisoft.com/smartgym.comunisoft.com/app_android/login_prueba.php?correo=" + correo + "&contrasena=" + contraseña);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            respuesta = connection.getResponseCode();

            resul = new String();

            if (respuesta == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader((new InputStreamReader(in)));

                while ((linea = reader.readLine()) != null) {
                    resul =linea;
                }

            }


        }catch (Exception e){

        }


        return  resul;

    }


    public int OBTENER_DATOS(String response){
        int res=0;

        try{


            String auxiliar="",cod="";
            String[] sep;
            sep = response.split(",");
            auxiliar= sep[0];
            datos[0] = sep[1];

            email = mEmailInput.getEditText().getText().toString();

            if(email.equalsIgnoreCase("")){
                email=linea;
            }

            cod=email;

            if(auxiliar.equalsIgnoreCase(cod)){
                res=1;

            }else{ }


            //JSONArray json= new JSONArray(response);
            //if(json.length()>0){
            //  res=1;

            // }
        }catch (Exception e){}
        return res;

    }


    public void mensaje(String Titulo, String Texto) {

        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setCancelable(true);
        builder.setTitle(Titulo);
        builder.setMessage(Texto);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });
        builder.show();


    }



}
