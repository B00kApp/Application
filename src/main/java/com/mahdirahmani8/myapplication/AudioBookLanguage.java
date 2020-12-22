package com.mahdirahmani8.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AudioBookLanguage  extends AppCompatActivity implements View.OnClickListener {


    Button fa,en,gr,es,ar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        setUpViews();

        fa.setOnClickListener(this);
        en.setOnClickListener(this);
        gr.setOnClickListener(this);
        es.setOnClickListener(this);
        ar.setOnClickListener(this);



    }


    @Override
    public void onClick(View v) {
        int viewID = v.getId();

        int id = getIntent().getExtras().getInt("ID");

        switch (viewID){

            case R.id.EN_id:

                Intent intent = new Intent (AudioBookLanguage.this , AudioRecicler.class);
                intent.putExtra("ID" , id);
                intent.putExtra("LAN", "en" );
                startActivity(intent);

                finish();
                break;

            case R.id.ES_id:

                Intent intent2 = new Intent (AudioBookLanguage.this , AudioRecicler.class);
                intent2.putExtra("ID" , id);
                intent2.putExtra("LAN","es");
                startActivity(intent2);

                finish();
                break;

            case R.id.AR_id:

                Intent intent3 = new Intent (AudioBookLanguage.this , AudioRecicler.class);
                intent3.putExtra("ID" , id);
                intent3.putExtra("LAN","ar");
                startActivity(intent3);

                finish();
                break;

            case R.id.FA_id:

                Intent intent4 = new Intent (AudioBookLanguage.this , AudioRecicler.class);
                intent4.putExtra("ID" , id);
                intent4.putExtra("LAN","fa");
                startActivity(intent4);

                finish();
                break;

            case R.id.GR_id:

                Intent intent5 = new Intent (AudioBookLanguage.this , AudioRecicler.class);
                intent5.putExtra("ID" , id);
                intent5.putExtra("LAN","gr");
                startActivity(intent5);
                finish();

                break;
        }

    }
    private void setUpViews(){
        fa = (Button) findViewById(R.id.FA_id);
        en = (Button) findViewById(R.id.EN_id);
        gr = (Button) findViewById(R.id.GR_id);
        es = (Button) findViewById(R.id.ES_id);
        ar = (Button) findViewById(R.id.AR_id);
    }
}
