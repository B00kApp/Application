package com.mahdirahmani8.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mahdirahmani8.myapplication.Adopter.BookAdopter;
import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.Model.Book;

import java.util.List;

public class ReciclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    BookAdopter adopter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_recicler);

        int id = getIntent().getExtras().getInt("ID");
        String lan = getIntent().getExtras().getString("LAN");

        setView(id , lan);

    }


    private void setView(int i , String lan){

        recyclerView = (RecyclerView) findViewById(R.id.REC_book_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(ReciclerActivity.this));

        DataBase db = new DataBase(ReciclerActivity.this);
        List<Book> bookList = db.getBooks( i ,lan );
        adopter = new BookAdopter(this, bookList , lan);
        recyclerView.setAdapter(adopter);
    }


}