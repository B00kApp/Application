package com.mahdirahmani8.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mahdirahmani8.myapplication.OnBoarding.Language_OnB;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText  name;
    Button next;
    boolean isLogin = false;
    private static  final String LOGIN = "login";
    String name_txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupViews();
    }

    private void setupViews() {
        name = (EditText) findViewById(R.id.name_ed_id);
        next = (Button) findViewById(R.id.go_to_app_id);
        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int viewID = view.getId();
        switch (viewID){
            case R.id.go_to_app_id:
                nameValidation();
                break;
        }
    }
    private void nameValidation (){
        name_txt = name.getText().toString().trim();
        if ( name_txt.isEmpty()){
            Toast.makeText(this,"Enter your name",Toast.LENGTH_SHORT).show();
        }else {
            saveName();
        }

    }
    private void saveName(){
        isLogin = !isLogin;
        SharedPreferences sharedPreferences = getSharedPreferences(LOGIN,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME",name_txt);
        editor.putBoolean("IsLogin",isLogin);
        editor.apply();
        gotoHome();
    }
    private void gotoHome (){
        Intent intent = new Intent(LoginActivity.this, Language_OnB.class);
        startActivity(intent);
        finish();
    }
}