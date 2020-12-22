package com.mahdirahmani8.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mahdirahmani8.myapplication.Adopter.AudioBook_SoundAdapter;
import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.Model.Audio;
import com.pnikosis.materialishprogress.ProgressWheel;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.hdodenhof.circleimageview.CircleImageView;

public class AudioBook extends AppCompatActivity implements View.OnClickListener {

    private CircleImageView image;
    private ImageView  back;
    private TextView name , source;
    private RecyclerView audios;
    private DataBase db;
    private int id, value;
    private AudioBook_SoundAdapter adapter;
    private com.google.android.material.floatingactionbutton.FloatingActionButton FAB;
    private ProgressWheel progressWheel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_book);

        Cast();

        getAndSet();

        favCondition();


        back.setOnClickListener(this);
        FAB.setOnClickListener(this);


    }

    private void getAndSet() {

        Intent intent = getIntent();

        String Name_part =  intent.getExtras().getString("NAME");
        name.setText(Name_part);
        source.setText(intent.getExtras().getString("ISONE"));
        String links = intent.getExtras().getString("DISC");
        id = intent.getExtras().getInt("ID");
        String Image_Link = intent.getExtras().getString("IMAGE");
        Glide.with(AudioBook.this).load(Image_Link).override(59, 59).into(image);


        //  Adapter
//        pullLinks(links)        String to Link Lists
        adapter = new AudioBook_SoundAdapter(AudioBook.this,pullLinks(links) , Name_part );
        audios.setAdapter(adapter);

    }



    private ArrayList pullLinks(String text) {
        ArrayList links = new ArrayList();

        String regex = "http.*//.*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);
        while(m.find()) {
            String urlStr = m.group();
            if (urlStr.startsWith("(") && urlStr.endsWith(")"))
            {
                urlStr = urlStr.substring(1, urlStr.length() - 1);
            }
            links.add(urlStr);
        }
        return links;
    }


    private void Cast(){
        image = (CircleImageView) findViewById(R.id.image_id);
        back = (ImageView) findViewById(R.id.back_id);
        name = (TextView) findViewById(R.id.Name);
        source = (TextView) findViewById(R.id.Source_id);
        FAB = (FloatingActionButton) findViewById(R.id.fab_id);
        progressWheel = (ProgressWheel) findViewById(R.id.Progress_id);

        audios = (RecyclerView) findViewById(R.id.REC_book_id);
        audios.setLayoutManager(new LinearLayoutManager(AudioBook.this));

    }



    @Override
    public void onClick(View v) {

        int viewID = v.getId();

        switch (viewID) {
            case R.id.back_id:
                onBackPressed();

                break;
            case R.id.fab_id:

                addOrRemoveFav();
                break;

        }
    }



    private void favCondition() {
        db = new DataBase(AudioBook.this);
        value = db.fav_value_Audio(id);

        if (value == 0) {

//            not fav

            FAB.setImageResource(R.drawable.heart_empty);
        } else if (value == 1) {

//            fav
            FAB.setImageResource(R.drawable.heart);

        }
    }

    private void addOrRemoveFav() {

        db = new DataBase(AudioBook.this);
        value = db.fav_value_Audio(id);

        if (value == 0) {

            db.fav_Audio(1, id);
            FAB.setImageResource(R.drawable.heart);
            Toast.makeText(AudioBook.this, "به لیست علاقه مندی ها اضافه شد", Toast.LENGTH_SHORT).show();

        } else if (value == 1) {

            db.fav_Audio(0, id);
            FAB.setImageResource(R.drawable.heart_empty);
            Toast.makeText(AudioBook.this, "از لیست علاقه مندی ها حذف شد", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}