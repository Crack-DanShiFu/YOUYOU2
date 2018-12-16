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

public class Personal_Information_Activity extends AppCompatActivity {
    private LinearLayout user_item;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.personal_information_layout);
        init();
        addListener();
    }

    public void init(){
        user_item =findViewById(R.id.user_item);
    }
    public void addListener(){
        user_item.setOnClickListener(new UserItemOnClickListener());
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    private class UserItemOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Personal_Information_Activity.this,
                    Account_select_Activity.class);
            startActivity(intent);
        }
    }
}
