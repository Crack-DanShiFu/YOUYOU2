package com.datiao.crack.youyou.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.datiao.crack.youyou.R;

public class New_HealthPlan_Activity extends AppCompatActivity {
    private ImageView new_planReturn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.new_healthplan_layout);
        init();
        addListener();
    }
    private void init(){
        new_planReturn = findViewById(R.id.new_plan_return);
    }
    private void addListener(){
        new_planReturn.setOnClickListener(new new_planReturn_LinearOnClickListener());
    }

    private class new_planReturn_LinearOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            finish();
        }
    }

}
