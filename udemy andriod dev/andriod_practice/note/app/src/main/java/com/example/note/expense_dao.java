package com.example.note;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface expense_dao {

    @Query("select * from expense")
    List<expenses> getallexpense();

    @Insert
    void insert(expenses ex);

    @Update
    void update(expenses ex);

    @Delete
    void delete(expenses ex);


}

