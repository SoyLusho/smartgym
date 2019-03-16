package com.smart.gym;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Pagos extends Fragment {

    private ListView lvPagos;
    private PagosListAdapter adapter;
    private List<Soporte_Pagos> mPagosList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_pagos, container, false);
        lvPagos = (ListView)v.findViewById(R.id.listview_pagos);


        final Carga_Pagos objeto2 = new Carga_Pagos();
        final String resultado = objeto2.consulta_pagos();
        mPagosList = new ArrayList<>();
        mPagosList = objeto2.OBTENER_DATOS(resultado);
        adapter = new PagosListAdapter(getActivity() ,mPagosList);
        lvPagos.setAdapter(adapter);


        return v;
    }

}
