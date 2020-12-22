package com.mahdirahmani8.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahdirahmani8.myapplication.Adopter.AudioAdopter;
import com.mahdirahmani8.myapplication.Adopter.AudioBookAdapter;
import com.mahdirahmani8.myapplication.Adopter.BookAdopter;
import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.Model.Audio;
import com.mahdirahmani8.myapplication.Model.Book;

import java.util.List;

public class AudioRecicler extends AppCompatActivity {
    RecyclerView recyclerView;
    AudioAdopter adopter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_recicler);

        int id = getIntent().getExtras().getInt("ID");
        String lan = getIntent().getExtras().getString("LAN");

        setView(id ,lan);


    }


    private void setView(int i , String lan){

        recyclerView = (RecyclerView) findViewById(R.id.REC_book_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(AudioRecicler.this));

        DataBase db = new DataBase(AudioRecicler.this);
        List<Audio> audioList = db.getAudio( i ,lan );
        adopter = new AudioAdopter(AudioRecicler.this, audioList);
        recyclerView.setAdapter(adopter);
    }
}
