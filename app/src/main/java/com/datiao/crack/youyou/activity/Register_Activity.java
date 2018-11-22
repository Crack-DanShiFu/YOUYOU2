package com.datiao.crack.youyou.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.datiao.crack.youyou.R;

/**
 * author: Crack
 * Email: 1124241615@qq.com
 * created on: 2018/11/22 11:04
 * description:
 */
public class Register_Activity extends AppCompatActivity {
    private TextView singin_Text;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        init();
        addListening();
    }
    private void init(){
        singin_Text = findViewById(R.id.Sing_in_Text);
    }
    private void addListening(){
        singin_Text.setOnClickListener(new SingInBtnOnClickListener());
    }

    private class SingInBtnOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            finish();
        }
    }
}
