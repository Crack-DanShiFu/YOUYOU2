package com.datiao.crack.youyou.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.datiao.crack.youyou.R;
import com.datiao.crack.youyou.activity.History_Activity;
import com.datiao.crack.youyou.activity.MainPage_Activity;
import com.orhanobut.logger.Logger;


/**
 * author: Crack
 * Email: 1124241615@qq.com
 * created on: 2018/11/22 15:55
 * description:
 */
public class Fragment1 extends Fragment {
    private ConstraintLayout fragment1_layout;
    private LinearLayout see_the_history;
    private LinearLayout new_plan;
    private ImageView more_info;
    private OnButtonClick onButtonClick;//2、定义接口成员变量
    private New_planClick new_planClick;
    private More_info_Click more_info_click;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment1_layout,container,false);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        fragment1_layout = new ConstraintLayout(getContext());
        init();
        addListener();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private void init(){
        see_the_history = (LinearLayout) getActivity().findViewById(R.id.See_the_history);
        new_plan=(getActivity().findViewById(R.id.new_plan));
        more_info = getActivity().findViewById(R.id.more_personal_information);
    }
    private void addListener(){
        see_the_history.setOnClickListener(new History_LinearOnClickListener());
        new_plan.setOnClickListener(new New_Plan_LinearOnClickListener());
        more_info.setOnClickListener(new More_info_LinearOnClickListener());
    }

    private class History_LinearOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            onButtonClick.onClick(see_the_history);
        }
    }

    private class New_Plan_LinearOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            new_planClick.onClick(new_plan);
        }
    }
    private class More_info_LinearOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            more_info_click.onClick(new_plan);
        }
    }

    //定义接口变量的get方法
    public OnButtonClick getOnButtonClick() {
        return onButtonClick;
    }

    public New_planClick getNew_planClick() { return new_planClick; }

    public More_info_Click getMore_info() {
        return more_info_click;
    }

    //定义接口变量的set方法
    public void setOnButtonClick(OnButtonClick onButtonClick) {
        this.onButtonClick = onButtonClick;
    }

    public void setNew_planClick(New_planClick new_planClick) {
        this.new_planClick = new_planClick;
    }

    public void setMore_infoClick(More_info_Click more_infoClick) {
        this.more_info_click = more_infoClick;
    }

    //1、定义接口
    public interface OnButtonClick{
        public void onClick(View view);
    }

    public interface New_planClick {
        public void onClick(View view);
    }
    public interface More_info_Click {
        public void onClick(View view);
    }
}
