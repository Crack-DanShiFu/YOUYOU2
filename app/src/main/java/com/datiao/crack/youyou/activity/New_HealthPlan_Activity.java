package com.datiao.crack.youyou.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.datiao.crack.youyou.R;
import com.datiao.crack.youyou.application.Plans_Application;
import com.datiao.crack.youyou.utils.PlansDBUtils;

import java.util.ArrayList;

public class New_HealthPlan_Activity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private ImageView new_planReturn;
    private GridLayout new_plan_gridlayout;
    private LinearLayout new_plan_item;
    private String[] new_plan_item_names;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.new_healthplan_layout);
        init();
        addListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        new_plan_gridlayout.removeAllViews();
        View view =  LayoutInflater.from(getBaseContext()).inflate(R.layout.new_item_btn, null);

        new_plan_gridlayout.addView(view);
        String[] names=sharedPreferences.getString("plans","").replaceFirst(",","").split(",");
        System.out.println(sharedPreferences.getString("plans","").replaceFirst(",",""));
        for (String s:names) {
            if(!s.equals("")){
                View view1 =  LayoutInflater.from(getBaseContext()).inflate(R.layout.new_plan_item, null);
                TextView textView=view1.findViewById(R.id.plan_name);
                textView.setText(s);
                new_plan_gridlayout.addView(view1);
            }
        }
        new_plan_item = (LinearLayout) new_plan_gridlayout.getChildAt(0);
        new_plan_item.setOnClickListener(new New_Plan_Item_LinearOnClickListener());
    }

    private void init(){
        new_planReturn = findViewById(R.id.new_plan_return);
        new_plan_gridlayout =findViewById(R.id.new_plan_gridlayout);
        sharedPreferences= getSharedPreferences("plans",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedPreferences.edit();
//        editor.putString("plans","");
//        editor.commit();

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
    private class New_Plan_Item_LinearOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
//            View view =  LayoutInflater.from(getBaseContext()).inflate(R.layout.new_plan_item, null);
//            new_plan_gridlayout.addView(view);
            Intent intent = new Intent(New_HealthPlan_Activity.this,
                    New_Healthplan_Info_Activity.class);
            startActivity(intent);
        }
    }

}
