package com.mahdirahmani8.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mahdirahmani8.myapplication.DataBase.DataBase;

import de.hdodenhof.circleimageview.CircleImageView;

public class Item_Book extends AppCompatActivity implements View.OnClickListener {

    CircleImageView image;
    TextView name, filed;
    TextView disc;

    int id;

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_book_activity);

        setupViews();
        getAndSetData();

    }

    private void setupViews() {
        image = (CircleImageView) findViewById(R.id.image_id);
        name = (TextView) findViewById(R.id.Name);
        disc = (TextView) findViewById(R.id.disc_id);
    }
    private void getAndSetData() {
        Intent intent = getIntent();
//        name.setText(intent.getExtras().getString("NAME"));
//        filed.setText(intent.getExtras().getString("FIELD"));
//        id = intent.getExtras().getInt("ID");
//        disc.setText(intent.getExtras().getString("DISC"));
//
//        String Image_Link = intent.getExtras().getString("IMAGE");
//        Glide.with(Item_Book.this).load(Image_Link).override(128, 128).into(image);

    }

}
