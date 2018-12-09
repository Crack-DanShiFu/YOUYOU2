package com.datiao.crack.youyou.model;

public class ToDoItem {
    private String medicine_name;
    private String medicine_sum;
    private String time_of_taking_medicine;

    public ToDoItem(String medicine_name, String medicine_sum, String time_of_taking_medicine) {
        this.medicine_name = medicine_name;
        this.medicine_sum = medicine_sum;
        this.time_of_taking_medicine = time_of_taking_medicine;
    }

    public ToDoItem() {
    }

    public String getMedicine_name() {
        return medicine_name;
    }

    public void setMedicine_name(String medicine_name) {
        this.medicine_name = medicine_name;
    }

    public String getMedicine_sum() {
        return medicine_sum;
    }

    public void setMedicine_sum(String medicine_sum) {
        this.medicine_sum = medicine_sum;
    }

    public String getTime_of_taking_medicine() {
        return time_of_taking_medicine;
    }

    public void setTime_of_taking_medicine(String time_of_taking_medicine) {
        this.time_of_taking_medicine = time_of_taking_medicine;
    }
}
