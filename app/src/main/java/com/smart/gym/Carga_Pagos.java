package com.smart.gym;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian on 15/03/2019.
 */

public class Carga_Pagos {

    public String consulta_pagos(){

       String respuesta = "[{\"id\":\"1\",\"fecha\":\"14/01/2019\",\"pago\": \"44000\"},{\"id\":\"2\",\"fecha\":\"15/02/2019\",\"pago\": \"44000\"},{\"id\":\"3\",\"fecha\":\"15/03/2019\",\"pago\": \"44000\"}]";

       return respuesta;
    }

    //llena ListView
    public List<Soporte_Pagos> OBTENER_DATOS(String response){

        Soporte_Pagos soporte;
        List<Soporte_Pagos> lista_pagos;

        lista_pagos = new ArrayList<>();

        try{

            JSONArray arrayJson = new JSONArray(response);
            for(int i=0; i<arrayJson.length(); i++){
                JSONObject objson = arrayJson.getJSONObject(i);
                soporte = new Soporte_Pagos(objson.getInt("id"), objson.getString("fecha"),objson.getString("pago"));
                //Log.i("codigo",soporte.getId()+soporte.getName());
                lista_pagos.add(soporte);

            }

        }catch (JSONException e){}

        return (lista_pagos);

    }



}
