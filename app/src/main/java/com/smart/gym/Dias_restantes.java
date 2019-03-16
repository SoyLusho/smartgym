package com.smart.gym;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Dias_restantes extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        Drawable myIcon = getResources().getDrawable( R.drawable.circulo_v);
        ColorFilter filter;
        filter = new LightingColorFilter( Color.rgb(0,87,74), Color.rgb(0,87,74));
        myIcon.setColorFilter(filter);

        return inflater.inflate(R.layout.activity_dias_restantes, container, false);
    }

}
