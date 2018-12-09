package com.datiao.crack.youyou.activity;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.datiao.crack.youyou.R;
import com.datiao.crack.youyou.component.BottomBar;
import com.datiao.crack.youyou.fragment.Fragment1;
import com.datiao.crack.youyou.fragment.Fragment2;
import com.datiao.crack.youyou.fragment.Fragment3;
import com.datiao.crack.youyou.fragment.Fragment4;
import com.datiao.crack.youyou.spacetablayout.SpaceTabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainPage_Activity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    SpaceTabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.main_page_layout);
        List<Fragment> fragmentList = new ArrayList<>();


        Fragment1 fragment1=new Fragment1();
        Fragment2 fragment2=new Fragment2();
        Fragment3 fragment3=new Fragment3();
        Fragment4 fragment4=new Fragment4();

        fragmentList.add(fragment1);
        fragmentList.add(fragment2);
        fragmentList.add(fragment3);
        fragmentList.add(fragment4);



        final CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_page_layout);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (SpaceTabLayout) findViewById(R.id.spaceTabLayout);

        tabLayout.initialize(viewPager, getSupportFragmentManager(), fragmentList);

//        tabLayout.setTabOneOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar snackbar = Snackbar
//                        .make(coordinatorLayout, "Welcome to SpaceTabLayout", Snackbar.LENGTH_SHORT);
//
//                snackbar.show();
//            }
//        });
//
//        tabLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplication(), "" + tabLayout.getCurrentPosition(), Toast.LENGTH_SHORT).show();
//            }
//        });
        fragment1.setOnButtonClick(new Fragment1.OnButtonClick() {
            @Override
            public void onClick(View view) {
                List<TabLayout.Tab> tabs=tabLayout.getTabs();
                for (TabLayout.Tab t : tabs) t.getCustomView().setAlpha(1);
                tabs.get(1).getCustomView().setAlpha(0);
                tabLayout.moveTab(tabLayout.getTabSize(), 1);
                tabLayout.setCurrentPosition(1);
            }
        });
        fragment1.setNew_planClick(new Fragment1.New_planClick() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage_Activity.this,
                        New_HealthPlan_Activity.class);
                startActivity(intent);
            }
        });
        fragment1.setNew_planClick(new Fragment1.New_planClick() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage_Activity.this,
                        New_HealthPlan_Activity.class);
                startActivity(intent);
            }
        });
        fragment1.setMore_infoClick(new Fragment1.More_info_Click(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainPage_Activity.this,
                        Personal_Information_Activity.class);
                startActivity(intent);
            }
        });

    }
}