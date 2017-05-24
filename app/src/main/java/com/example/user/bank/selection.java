package com.example.user.bank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class selection extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
    }
    public void openmain(View view){
        Intent it = new Intent(this,MainActivity.class);
        startActivity(it);
    }

    public void opencheck(View v){
        Intent it2 = new Intent(this,check.class);
        startActivity(it2);
    }

    public void opensetting(View v){
        Intent it3 = new Intent(this,setting.class);
        startActivity(it3);
    }
}
