package com.mahdirahmani8.myapplication.UserActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.mahdirahmani8.myapplication.Adopter.FavAdopter;
import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.FavAudioBook;
import com.mahdirahmani8.myapplication.FavBook;
import com.mahdirahmani8.myapplication.R;

public class Fav extends AppCompatActivity {

    private TextView story, audioBook, fav;
    private RelativeLayout rel1 , rel2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav);

        // Cast
        rel1 = (RelativeLayout) findViewById(R.id.REL1);
        rel2 = (RelativeLayout) findViewById(R.id.REL2);
        story = (TextView) findViewById(R.id.S_TXT);
        audioBook = (TextView) findViewById(R.id.AB_TXT);
        fav = (TextView) findViewById(R.id.FAV_TXT);

        Lan();



//        Intent Audio Book
        rel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Fav.this , FavAudioBook.class);
                startActivity(intent);
                finish();
            }
        });

        // Intent Book
        rel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Fav.this, FavBook.class);
                startActivity(intent1);
                finish();
            }
        });


    }
    private void Lan() {
        DataBase db = new DataBase(this);
        String str = db.lanValue();

        if ( str != null  && str.hashCode() == 3259) {   // fa

            story.setText("داستان");
            audioBook.setText("کتاب صوتی");
            fav.setText("علاقه مندی ها");

        } else if (str != null  && str.hashCode() == 3246) {   //sp

            story.setText("Historia");
            audioBook.setText("audio libro");
            fav.setText("Favoritos");

        } else if (str != null  && str.hashCode() == 3307) {   // gr

            story.setText("Geschichte");
            audioBook.setText("Hörbuch");
            fav.setText("Favoriten");

        } else if (str != null  && str.hashCode() == 3121) {    // ar

            story.setText("قصة");
            audioBook.setText("كتاب صوتي");
            fav.setText("المفضلة");

        } else {    //en


        }

    }


}