package com.example.notetakingapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {note.class},version = 1)
public abstract class  note_database extends RoomDatabase {
    private static note_database instance;

    public abstract not_dao note_dao();

    public static synchronized note_database getInstance(Context context){
        if(instance==null)
        {
            instance = Room.databaseBuilder(context.getApplicationContext(),note_database.class,
                    "note_database").fallbackToDestructiveMigration().build();
        }
        return instance;
    }


}
