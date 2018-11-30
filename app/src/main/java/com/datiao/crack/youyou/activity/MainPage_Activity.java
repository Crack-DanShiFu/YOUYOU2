package com.datiao.crack.youyou.activity;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.datiao.crack.youyou.R;
import com.datiao.crack.youyou.component.BottomBar;
import com.datiao.crack.youyou.fragment.Fragment1;
import com.datiao.crack.youyou.fragment.Fragment2;
import com.datiao.crack.youyou.fragment.Fragment3;
import com.datiao.crack.youyou.fragment.Fragment4;

public class MainPage_Activity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.main_page_layout);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottom_bar);
        bottomBar.setContainer(R.id.fl_container)
                .setTitleBeforeAndAfterColor("#999999", "#3a429a")
                .addItem(Fragment1.class,
                        "主页",
                        R.drawable.item1_gray,
                        R.drawable.item1_blue)
                .addItem(Fragment2.class,
                        "记录",
                        R.drawable.item2_gray,
                        R.drawable.item2_blue)
                .addItem(Fragment3.class,
                        "商城",
                        R.drawable.item3_gray,
                        R.drawable.item3_blue)
                .addItem(Fragment4.class,
                        "健康贴士",
                        R.drawable.item4_gray,
                        R.drawable.item4_blue)
                .build();
    }
}