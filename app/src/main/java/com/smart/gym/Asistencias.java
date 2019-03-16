package com.smart.gym;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class Asistencias extends Fragment {

    private ListView lvAsistencias;
    private AsistenciasListAdapter adapter;
    private List<Soporte_Asistencias> mAsistenciasList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_asistencias, container, false);
        lvAsistencias = (ListView)v.findViewById(R.id.listview_asistencias);


        final Carga_Asistencias objeto2 = new Carga_Asistencias();
        final String resultado = objeto2.consulta_asistencias();
        mAsistenciasList = new ArrayList<>();
        mAsistenciasList = objeto2.OBTENER_DATOS(resultado);
        adapter = new AsistenciasListAdapter(getActivity() ,mAsistenciasList);
        lvAsistencias.setAdapter(adapter);





        return v;
    }

}
