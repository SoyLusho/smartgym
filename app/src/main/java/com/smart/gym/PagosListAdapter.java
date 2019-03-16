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

public class PagosListAdapter extends BaseAdapter {

    private Context mContext;
    private List<Soporte_Pagos> mPagosList;

    //constructor


    public PagosListAdapter(Context mContext, List<Soporte_Pagos> mProductList) {
        this.mContext = mContext;
        this.mPagosList = mProductList;
    }


    @Override
    public int getCount() {
        return mPagosList.size();
    }

    @Override
    public Object getItem(int position) {
        return mPagosList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v= View.inflate(mContext, R.layout.formato_pagos,null);
        TextView fecha = (TextView)v.findViewById(R.id.fecha);
        TextView numero= (TextView)v.findViewById(R.id.numero);
        TextView valor_pago= (TextView)v.findViewById(R.id.valor_pago);

        //set text for TextView
        fecha.setText(mPagosList.get(position).getFecha());
        valor_pago.setText(mPagosList.get(position).getPago());

        int x = mPagosList.get(position).getId();
        numero.setText(""+x);

        //save product id to tag

        v.setTag(mPagosList.get(position).getId());

        return v;
    }
}
