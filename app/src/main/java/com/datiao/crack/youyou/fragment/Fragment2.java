package com.datiao.crack.youyou.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.datiao.crack.youyou.Adapter.ToDoItemAdapter;
import com.datiao.crack.youyou.R;
import com.datiao.crack.youyou.activity.History_Activity;
import com.datiao.crack.youyou.activity.Login_Activity;
import com.datiao.crack.youyou.activity.Register_Activity;
import com.datiao.crack.youyou.model.ToDoItem;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Crack
 * Email: 1124241615@qq.com
 * created on: 2018/11/22 15:58
 * description:
 */
public class Fragment2 extends Fragment {
    private ListView listView;
    private List<ToDoItem> toDoItemList;
    private ToDoItemAdapter toDoItemAdapter;
    private LinearLayout history_linear;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment2_layout,container,false);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onStart() {
        super.onStart();
        init();
        String[] names = { "阿司匹林", "降压药", "降压药", "阿司匹林","阿司匹林", "降压药", "降压药", "阿司匹林"};
        String[] sum = { "两颗", "两颗", "两颗", "两颗","两颗", "两颗", "两颗", "两颗"};
        String[] time = { "9:00", "9:00", "10:00", "16:00","9:00", "9:00", "10:00", "16:00"};
        for(int i=0;i<names.length;i++)
            toDoItemList.add(new ToDoItem(names[i],sum[i],time[i],R.drawable.yaoxiang,R.drawable.cha));
        listView.setDividerHeight(50);
        listView.setAdapter(toDoItemAdapter);
        addListener();
    }
    private void init(){
        history_linear = getActivity().findViewById(R.id.history_linear);
        listView =this.getActivity().findViewById(R.id.today_record_ListView);
        toDoItemList=new ArrayList();
        toDoItemAdapter=new ToDoItemAdapter(getActivity(),R.layout.myitem,toDoItemList);
    }
    private void addListener(){
        history_linear.setOnClickListener(new History_LinearOnClickListener());
    }

    private class History_LinearOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(),
                    History_Activity.class);
            startActivity(intent);
        }
    }

}
