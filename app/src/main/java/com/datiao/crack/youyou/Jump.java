package com.datiao.crack.youyou;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.datiao.crack.youyou.activity.Login_Activity;
import com.datiao.crack.youyou.activity.MainPage_Activity;

public class Jump extends AppCompatActivity {

    private static final int SPLASH_DISPLAY_LENGHT_3000 = 1000;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_jump);
        sharedPreferences = getSharedPreferences("Login",Context.MODE_PRIVATE);
        check_Login_status();
    }

    public void check_Login_status(){
        Boolean isLogin = sharedPreferences.getBoolean("isLogin",false);

        if(true){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    Intent intent = new Intent(Jump.this,
                            MainPage_Activity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_DISPLAY_LENGHT_3000);
        }else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
                    Intent intent = new Intent(Jump.this,
                            Login_Activity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_DISPLAY_LENGHT_3000);
        }
    }
}
