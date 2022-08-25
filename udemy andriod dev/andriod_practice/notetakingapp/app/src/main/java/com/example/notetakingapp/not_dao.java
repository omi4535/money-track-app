package com.example.notetakingapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface not_dao {
    @Insert
    void insert(note n);

    @Delete
    void delete(note n);

    @Update
    void update(note n);

    @Query("select * from note_table order by id asc")
    LiveData<List<note>> getAllNotes();
}
