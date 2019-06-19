package com.smart.gym;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView ico_splash;
    private boolean yes=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        ico_splash = (ImageView)findViewById(R.id.ico_splash);

        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_left);
        ico_splash.setAnimation(anim);


        anim.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                Cargar_Init();

            }
        });

    }// cierre de on create

    public void Cargar_Init(){

        SharedPreferences Session=getSharedPreferences("session_init", Context.MODE_PRIVATE);

        yes= (Session.getBoolean("yes", false));

        if(yes == true){
            Intent i = new Intent(SplashActivity.this, MenuActivity.class);
            SplashActivity.this.startActivity(i);
            finish();
        }else{
            Intent i = new Intent(SplashActivity.this, LoginActivity.class);
            SplashActivity.this.startActivity(i);
            finish();
        }


    }

}
