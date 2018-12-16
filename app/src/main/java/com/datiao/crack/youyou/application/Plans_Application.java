package com.datiao.crack.youyou.application;

import android.app.Application;

import java.util.ArrayList;

public class Plans_Application extends Application {
    private ArrayList<String> plans=new ArrayList();

    public ArrayList<String> getPlans() {
        return plans;
    }

    public void setPlans(ArrayList<String> plans) {
        this.plans = plans;
    }
    public void addPlans(String plan){
        this.plans.add(plan);
    }
}
