package com.datiao.crack.youyou.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.datiao.crack.youyou.R;

/**
 * author: Crack
 * Email: 1124241615@qq.com
 * created on: 2018/11/22 15:58
 * description:
 */
public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment2_layout,container,false);
        return view;
    }
}
