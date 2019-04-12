package com.smart.gym;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button entrar;
    InterstitialAd interstitialAd; // Publicidad pantalla completa
    AdView adView; //publicidad tipo Banner osea pequeñita

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

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

     Intent i=new Intent(getApplicationContext(),MenuActivity.class);
     startActivity(i);
     finish();
    }


}
