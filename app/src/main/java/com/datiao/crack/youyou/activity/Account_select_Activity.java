package com.datiao.crack.youyou.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.datiao.crack.youyou.R;

public class Account_select_Activity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private LinearLayout loginoutitem;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.account_select_layout);
        init();
        addListener();
    }

    private void init() {
        loginoutitem=findViewById(R.id.loginoutitem);
        sharedPreferences= getSharedPreferences("Login",Context.MODE_PRIVATE);
    }
    private void addListener(){
        loginoutitem.setOnClickListener(new LoginOutItemOnClickListener());
    }

    private class LoginOutItemOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            SharedPreferences.Editor editor =sharedPreferences.edit();
            editor.putBoolean("isLogin",false);
            editor.commit();
            Intent intent = new Intent(Account_select_Activity.this,
                    Login_Activity.class);
            startActivity(intent);
        }
    }
}
