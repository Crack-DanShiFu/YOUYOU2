package com.datiao.crack.youyou.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.datiao.crack.youyou.R;
import com.datiao.crack.youyou.model.ToDoItem;

import java.util.List;

public class ToDoItemAdapter extends ArrayAdapter<ToDoItem> {
    private int resource_id;

    public ToDoItemAdapter(Context context, int resource_id, List<ToDoItem> items) {
        super(context, resource_id, items);
        this.resource_id = resource_id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout todoView;

        ToDoItem toDoItem=getItem(position);
        if(convertView==null){//不是一次更新，则填充一个新视图
            todoView=new LinearLayout(getContext());
            LayoutInflater layoutInflater=(LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layoutInflater.inflate(resource_id,todoView,true);
        }else {//否则更新该视图
            todoView=(LinearLayout)convertView;
        }
        //得到对象的各个属性值
        TextView medicine_name=(TextView)todoView.findViewById(R.id.medicine_name);
        TextView medicine_sum=(TextView)todoView.findViewById(R.id.medicine_sum);
        TextView time_of_taking_medicine=(TextView)todoView.findViewById(R.id.time_of_taking_medicine);
        ImageView right_img = todoView.findViewById(R.id.item_right_icon);
        ImageView left_img = todoView.findViewById(R.id.item_left_icon);
        //填充该Item 中各个View的内容
        medicine_name.setText(toDoItem.getMedicine_name());
        medicine_sum.setText(toDoItem.getMedicine_sum());
        time_of_taking_medicine.setText(toDoItem.getTime_of_taking_medicine());
        right_img.setBackgroundResource(toDoItem.getRight_img());
        left_img.setBackgroundResource(toDoItem.getLeft_img());
        return todoView;
    }


}
