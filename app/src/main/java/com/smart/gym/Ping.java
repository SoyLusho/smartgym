package com.smart.gym;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Ping {


    public String Ping() {

        URL url = null;
        String linea = "";
        int respuesta = 0;
        String ping = "";


        try {
            url = new URL("https://comunisoft.com/smartgym.comunisoft.com/app_android/ping.php");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            respuesta = connection.getResponseCode();

            ping = new String();

            if (respuesta == HttpURLConnection.HTTP_OK) {
                InputStream in = new BufferedInputStream(connection.getInputStream());
                BufferedReader reader = new BufferedReader((new InputStreamReader(in)));

                while ((linea = reader.readLine()) != null) {
                    ping = (linea);

                }
            }

        } catch (Exception e) {
        }


        return ping;


    }

    public int verificar_ping(String ping) {
        int verificar = 0;

        try {
            String linea = "";
            linea = ping;
            //Log.d("Hola","dato: "+linea);

            if (linea.equalsIgnoreCase("ok")) {
                verificar = 1;
            }else {
                verificar = 0;
            }


        } catch (Exception e) {
        }
        return verificar;
    }



}
