package com.mahdirahmani8.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }
    private void setupViews (){
        frameLayout = (FrameLayout)findViewById(R.id.frame_id);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottem_nav_id);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_id,new HomeFragment()).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int navID = item.getItemId();

        switch (navID){
            case R.id.home_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_id,new HomeFragment()).commit();
                break;

            case R.id.search_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_id,new SearchFragment()).commit();
                break;

            case R.id.user_id:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_id,new UserFragment()).commit();
                break;

        }

        return true;
    }
}