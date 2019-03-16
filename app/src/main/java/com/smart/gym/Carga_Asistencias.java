package com.smart.gym;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian on 15/03/2019.
 */

public class Carga_Asistencias {

    public String consulta_asistencias(){

       String respuesta = "[{\"id\":\"1\",\"fecha\":\"14/03/2019\"},{\"id\":\"2\",\"fecha\":\"15/03/2019\"}]";

       return respuesta;
    }

    //llena ListView
    public List<Soporte_Asistencias> OBTENER_DATOS(String response){

        Soporte_Asistencias soporte;
        List<Soporte_Asistencias> lista_Asistencias;

        lista_Asistencias = new ArrayList<>();

        try{

            JSONArray arrayJson = new JSONArray(response);
            for(int i=0; i<arrayJson.length(); i++){
                JSONObject objson = arrayJson.getJSONObject(i);
                soporte = new Soporte_Asistencias(objson.getInt("id"), objson.getString("fecha"));
                //Log.i("codigo",soporte.getId()+soporte.getName());
                lista_Asistencias.add(soporte);

            }

        }catch (JSONException e){}

        return (lista_Asistencias);

    }



}
