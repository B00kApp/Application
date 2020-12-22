package com.mahdirahmani8.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mahdirahmani8.myapplication.Adopter.FavAdopter;
import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.Model.Book;
import com.mahdirahmani8.myapplication.Model.Item;

import java.util.List;

public class FavBook extends AppCompatActivity {

    private FavAdopter favAdopter;
    private RecyclerView recyclerView;
    private LinearLayout linearLayout;
    private TextView bg, tv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_book);

        cast();

    }

    private void cast() {
        linearLayout = (LinearLayout) findViewById(R.id.FAV_Linear);
        recyclerView = (RecyclerView) findViewById(R.id.BookFavREC);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        bg = (TextView) findViewById(R.id.like_txt);
        tv = (TextView) findViewById(R.id.FAV_book_txt) ;

        Lan();


        DataBase db = new DataBase(this);
        List<Book> bookList = db.getFav();


        if (!bookList.isEmpty()){
            hiddenBG();
        }else {
            showBG();
        }

        favAdopter = new FavAdopter(this,bookList);
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

            tv.setText("داستان ");
            bg.setText("موردی را پسند کنید ...");

        } else if (str != null  && str.hashCode() == 3246) {   //sp

            tv.setText("Historia");
            bg.setText("Como algo ...");

        } else if (str != null  && str.hashCode() == 3307) {   // gr
            tv.setText("Geschichte");
            bg.setText("Wie etwas ...");

        } else if (str != null  && str.hashCode() == 3121) {    // ar
            tv.setText("قصة");
            bg.setText("مثل كذا ...");

        } else {    //en

            tv.setText("Story");
            bg.setText("Like something ...");
        }

    }




}