package com.mahdirahmani8.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.mahdirahmani8.myapplication.DataBase.DataBase;
import com.mahdirahmani8.myapplication.UserActivity.AbouUs;
import com.mahdirahmani8.myapplication.UserActivity.Fav;
import com.mahdirahmani8.myapplication.UserActivity.Setting_Activity;
import com.mahdirahmani8.myapplication.UserActivity.Writer;

import java.util.TimerTask;

//import android.widget.Toolbar;

public class ContentActivity extends AppCompatActivity implements View.OnClickListener , NavigationView.OnNavigationItemSelectedListener
{

    private ImageView  back;
    private TextView name , textView;
    private TextView disc;
    private ScrollView scrollView;
    private FloatingActionButton fab;
    private Button language;
    private DataBase db;
    private LinearLayout lin;
    private RelativeLayout BG;
    private LinearLayout linearLayout;
    private int id, value;
    private String size, background, font ,autoScroll;
    private String lan;
    private int request = 0;

    // Dr layout
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.drawerlayout);


        setupViews();

        getAndSetData();

        favCondition();

        setColor();

        SetFont();

        SetBG();

//        int speed = 500;
//        Timer timer = new Timer();
//        timer.schedule(new timer_task(), 1000, speed);


//        back.setOnClickListener(this);
        navigationView.setNavigationItemSelectedListener(this);
        fab.setOnClickListener(this);
    }


    private void SetBG() {
        DataBase db = new DataBase(this);

        int bg = db.getBg();

        if (bg ==1){
            BG.setBackgroundResource(R.drawable.a);
        }else if (bg == 2){
            BG.setBackgroundResource(R.drawable.b);
        }else if (bg == 3){
            BG.setBackgroundResource(R.drawable.c);
        }else if (bg == 4){
            BG.setBackgroundResource(R.drawable.d);
        }else if (bg == 5){
            BG.setBackgroundResource(R.drawable.e);
        }else if (bg == 6){
            BG.setBackgroundResource(R.drawable.f);
        }else if (bg == 7){
            BG.setBackgroundResource(R.drawable.g);
        }else if (bg == 8){
            BG.setBackgroundResource(R.drawable.i);
        }

    }

    private void SetFont() {
        DataBase db = new DataBase(this);
        int val = db.getFont();

        if (val == 1){

            Typeface F1 = Typeface.createFromAsset(getAssets(),"font/amiri.ttf");
            disc.setTypeface(F1);


        }else if (val == 2){

            Typeface F2 = Typeface.createFromAsset(getAssets(),"font/banoo.ttf");
            disc.setTypeface(F2);

        }else if (val == 3){

            Typeface F3 = Typeface.createFromAsset(getAssets(),"font/changa.ttf");
            disc.setTypeface(F3);

        }else if (val == 4){

            Typeface F4 = Typeface.createFromAsset(getAssets(),"font/jomhuria.ttf");
            disc.setTypeface(F4);

        }else if (val == 5){

            Typeface F5 = Typeface.createFromAsset(getAssets(),"font/kodakku.ttf");
            disc.setTypeface(F5);

        }else if (val == 6){

            Typeface F6 = Typeface.createFromAsset(getAssets(),"font/mirza.ttf");
            disc.setTypeface(F6);

        }else if (val == 7){

            Typeface F7 = Typeface.createFromAsset(getAssets(),"font/nazanin.TTF");
            disc.setTypeface(F7);

        }else if (val == 8){

            Typeface F8 = Typeface.createFromAsset(getAssets(),"font/roya.ttf");
            disc.setTypeface(F8);

        }else if (val == 9){

            Typeface F9 = Typeface.createFromAsset(getAssets(),"font/vazir.ttf");
            disc.setTypeface(F9);
        }

    }

    private void setColor() {
        DataBase db = new DataBase(this);

        int color = db.getColor();

        if (color == 1){
            disc.setTextColor(Color.WHITE);
        }else {
            disc.setTextColor(Color.BLACK);
        }

    }


    private void getAndSetData() {
        Intent intent = getIntent();
        name.setText(intent.getExtras().getString("NAME"));
        id = intent.getExtras().getInt("ID");
        disc.setText(intent.getExtras().getString("DISC"));

        DataBase db = new DataBase(ContentActivity.this);
        disc.setTextSize(db.sizeValue());
        lan = intent.getExtras().getString("LAN");                 // for ltr or rtl music fab  and heart fab

        if (lan.hashCode() == 3121 || lan.hashCode() == 3259){
            lin.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
            scrollView.setTextDirection(View.TEXT_DIRECTION_RTL);
        }else {
            lin.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
            scrollView.setTextDirection(View.TEXT_DIRECTION_LTR);
        }
    }


    private void setupViews() {
        back = (ImageView) findViewById(R.id.back_id);
        name = (TextView) findViewById(R.id.Name);
        disc = (TextView) findViewById(R.id.disc_id);
        fab = (FloatingActionButton) findViewById(R.id.fab_id);
        scrollView = (ScrollView) findViewById(R.id.Scroll_content_id);
        linearLayout = (LinearLayout) findViewById(R.id.image_bg_id);

        drawerLayout = (DrawerLayout) findViewById(R.id.DR_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        lin = (LinearLayout) findViewById(R.id.Dir_FAV);

        BG = (RelativeLayout) findViewById(R.id.BG_Content);
        textView =(TextView) findViewById(R.id.TEXT);
        language = (Button) findViewById(R.id.Language);


        Toolbar toolbar =  findViewById(R.id.Top_layer_Content);
        setSupportActionBar( toolbar );

        ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(this , drawerLayout , toolbar ,R.string.open,R.string.close);

        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

    }



    @Override
    public void onClick(View v) {

        int viewID = v.getId();

        switch (viewID) {
//            case R.id.back_id:
//                onBackPressed();
//
//                break;
            case R.id.fab_id:

                addOrRemoveFav();
                break;
        }
    }



    private void favCondition() {
        db = new DataBase(ContentActivity.this);
        value = db.fav_value(id);

        if (value == 0) {

//            not fav

            fab.setImageResource(R.drawable.heart_empty);
        } else if (value == 1) {

//            fav
            fab.setImageResource(R.drawable.heart);

        }
    }

    private void addOrRemoveFav() {

        db = new DataBase(ContentActivity.this);
        value = db.fav_value(id);

        if (value == 0) {

            db.fav(1, id);
            fab.setImageResource(R.drawable.heart);
            Toast.makeText(ContentActivity.this, "Add", Toast.LENGTH_SHORT).show();

        } else if (value == 1) {

            db.fav(0, id);
            fab.setImageResource(R.drawable.heart_empty);
            Toast.makeText(ContentActivity.this, "Remove", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        db = new DataBase(this);
//        List<Setting> settings =  db.setting_reade();

        AlertDialog.Builder aBuilder;

        switch (item.getItemId()){

            case R.id.fav:
                Intent fav = new Intent(this, Fav.class);
                startActivity(fav);
                break;

            case R.id.setting:

                Intent setting = new Intent(this , Setting_Activity.class);
                setting.putExtra("IF",false);
                startActivityForResult(setting, request);
                break;

            case R.id.about:
                Intent about = new Intent(ContentActivity.this , AbouUs.class);
                startActivity(about);
                break;

            case R.id.you_writer:
                Intent intent = new Intent(ContentActivity.this , Writer.class);
                startActivity(intent);
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true ;
    }


    //    // Auto Scroll
    //  TODO   better scroll and add menu in left
    public class timer_task extends TimerTask {

        @Override
        public void run() {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    scrollView.arrowScroll(View.FOCUS_DOWN);
                }
            });
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            recreate();

    }
}