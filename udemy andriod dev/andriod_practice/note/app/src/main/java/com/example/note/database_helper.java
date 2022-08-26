package com.example.note;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = expenses.class,exportSchema = false,version = 1)
public abstract class database_helper extends RoomDatabase {

    final static String db_name = "expensedb";
    private static database_helper instace;

    public static synchronized database_helper getdb(Context context) {
        if(instace == null)
        {
            instace = Room.databaseBuilder(context,database_helper.class,db_name)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries().build();
        }
        return  instace;
    }

    public abstract expense_dao e_dao();
}

