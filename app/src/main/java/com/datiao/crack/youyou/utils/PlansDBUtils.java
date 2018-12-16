package com.datiao.crack.youyou.utils;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PlansDBUtils extends SQLiteOpenHelper {

    //数据库名称
    private static String name = "plans.db";
    //数据库版本号
    private static Integer version = 1;

    public PlansDBUtils(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //执行数据库创建表的语句
        db.execSQL("create table plans(id integer primary key autoincrement,plan_name varchar(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
