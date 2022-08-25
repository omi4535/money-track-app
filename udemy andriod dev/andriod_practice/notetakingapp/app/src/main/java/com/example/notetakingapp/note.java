package com.example.notetakingapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class note {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String title;

    public String content;

    public note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
