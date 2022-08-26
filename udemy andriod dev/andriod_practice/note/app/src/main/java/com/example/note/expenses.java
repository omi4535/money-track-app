package com.example.note;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "expense")
public class expenses {

    @Ignore
    expenses(int id,String  title, double amount){
        this.id= id;
        this.amount= amount;
        this.title=title;
    }

    expenses(String  title, double amount){

        this.amount= amount;
        this.title=title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @PrimaryKey(autoGenerate = true)
    private  int id;

    @ColumnInfo(name = "title")
    private  String title;

    @ColumnInfo(name = "amount")
    private double amount;
}
