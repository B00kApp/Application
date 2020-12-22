package com.mahdirahmani8.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahdirahmani8.myapplication.Adopter.FavAdopter;
import com.mahdirahmani8.myapplication.Adopter.FavAudioAdapter;
import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.Model.Audio;

import java.util.List;

public class FavAudioBook extends AppCompatActivity {

    private FavAudioAdapter favAdopter;
    private RecyclerView recyclerView;
    private LinearLayout linearLayout;
    private TextView tv , bg ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_audio_book);

        cast();

    }

    private void cast() {
        linearLayout = (LinearLayout) findViewById(R.id.FAV_Linear);

        recyclerView = (RecyclerView) findViewById(R.id.BookFavREC);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        tv = (TextView) findViewById(R.id.tv);
        bg = (TextView) findViewById(R.id.like_txt);

        Lan();

        DataBase db = new DataBase(this);
        List<Audio> bookList = db.getAudioFav();

        if (!bookList.isEmpty()){
            hiddenBG();
        }else {
            showBG();
        }

        favAdopter = new FavAudioAdapter(this,bookList);
        recyclerView.setAdapter(favAdopter);

    }

    private void showBG() {
        linearLayout.setVisibility(View.VISIBLE);
    }

    private void hiddenBG() {
        linearLayout.setVisibility(View.GONE);
    }

    private void Lan() {
        DataBase db = new DataBase(this);
        String str = db.lanValue();


        if ( str != null  && str.hashCode() == 3259) {   // fa

            tv.setText("کتاب صوتی");
            bg.setText("موردی را پسند کنید ...");

        } else if (str != null  && str.hashCode() == 3246) {   //sp

            tv.setText("audio libro");
            bg.setText("Como algo ...");

        } else if (str != null  && str.hashCode() == 3307) {   // gr

            tv.setText("Hörbuch");
            bg.setText("Wie etwas ...");

        } else if (str != null  && str.hashCode() == 3121) {    // ar

            tv.setText("كتاب صوتي");
            bg.setText("مثل كذا ...");

        } else {    //en

            tv.setText("audio book");
            bg.setText("Like something ...");
        }

    }


}