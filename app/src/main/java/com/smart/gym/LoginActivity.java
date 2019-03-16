package com.smart.gym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        entrar=(Button)findViewById(R.id.button1);
        entrar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

     Intent i=new Intent(getApplicationContext(),MenuActivity.class);
     startActivity(i);
     finish();
    }


}
