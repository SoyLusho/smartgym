package com.smart.gym;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cristian Lozada on 15/03/2019.
 */

public class AsistenciasListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Soporte_Asistencias> mAsistenciasList;

    //constructor


    public AsistenciasListAdapter(Context mContext, List<Soporte_Asistencias> mProductList) {
        this.mContext = mContext;
        this.mAsistenciasList = mProductList;
    }


    @Override
    public int getCount() {
        return mAsistenciasList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAsistenciasList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v= View.inflate(mContext, R.layout.formato_asistencias,null);
        TextView nombre= (TextView)v.findViewById(R.id.fecha);
        TextView numero= (TextView)v.findViewById(R.id.numero);

        //set text for TextView
        nombre.setText(mAsistenciasList.get(position).getName());

        int x = mAsistenciasList.get(position).getId();
        numero.setText(""+x);

        //save product id to tag

        v.setTag(mAsistenciasList.get(position).getId());

        return v;
    }
}
