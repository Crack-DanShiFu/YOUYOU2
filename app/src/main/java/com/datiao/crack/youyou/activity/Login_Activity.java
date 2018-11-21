package com.datiao.crack.youyou.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.datiao.crack.youyou.R;

public class Login_Activity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        sharedPreferences= getSharedPreferences("Login",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
        editor.putBoolean("isLogin",true);
        editor.commit();
        setContentView(R.layout.login_layout);
    }
    private void init(){
    }
}
