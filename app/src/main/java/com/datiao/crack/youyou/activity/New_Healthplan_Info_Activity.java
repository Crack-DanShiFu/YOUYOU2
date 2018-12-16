package com.datiao.crack.youyou.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.datiao.crack.youyou.R;


public class New_Healthplan_Info_Activity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText new_plan_name;
    Button new_plan_queren_btn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.new_healthplan_info_layout);
        init();
        addListener();
    }

    private void addListener() {
        new_plan_queren_btn.setOnClickListener(new New_Plan_queren_btnLinearOnClickListener());
    }

    private void init() {
        new_plan_name = findViewById(R.id.new_plan_name);
        new_plan_queren_btn=findViewById(R.id.new_plan_queren_btn);

        sharedPreferences= getSharedPreferences("plans",Context.MODE_PRIVATE);

    }
    private class New_Plan_queren_btnLinearOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
//            View view =  LayoutInflater.from(getBaseContext()).inflate(R.layout.new_plan_item, null);
//            new_plan_gridlayout.addView(view);
            if(!new_plan_name.getText().toString().equals("")){
            SharedPreferences.Editor editor =sharedPreferences.edit();
            String s =sharedPreferences.getString("plans","")+","+new_plan_name.getText().toString();
            editor.putString("plans",s);
            editor.commit();
            }
            finish();
        }
    }

}
