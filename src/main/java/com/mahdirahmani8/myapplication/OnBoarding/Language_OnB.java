package com.mahdirahmani8.myapplication.OnBoarding;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.R;

public class Language_OnB extends AppCompatActivity {

    private ImageView en,sp,gr,ar,fa;
    private  Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language__on_b);

        cast();
        // Open Database
        DataBase db = new DataBase(this);
        intent = new Intent(Language_OnB.this, OnBoarding.class);


        // English
        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.setLan("en");
                startActivity(intent);
                finish();

            }
        });

        // Spanish
        sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.setLan("es");
                startActivity(intent);
                finish();
            }
        });

        // germany
        gr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.setLan("gr");
                startActivity(intent);
                finish();
            }
        });

        // Arabic
        ar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.setLan("ar");
                startActivity(intent);
                finish();
            }
        });

        // Persian
        fa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.setLan("fa");
                startActivity(intent);
                finish();
            }
        });



    }

    private void cast() {
        en = (ImageView) findViewById(R.id.en);
        sp = (ImageView) findViewById(R.id.sp);
        gr = (ImageView) findViewById(R.id.gr);
        ar = (ImageView) findViewById(R.id.ar);
        fa = (ImageView) findViewById(R.id.fa);

    }
}