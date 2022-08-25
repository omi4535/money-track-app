package com.example.notetakingapp;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class repository {

    private not_dao note_dao;
    private LiveData<List<note>> notes;

    // for inset delete and update operation
    ExecutorService executor = Executors.newSingleThreadExecutor();
    public repository(Application application){
        note_database database = note_database.getInstance(application);

        note_dao =database.note_dao();

        notes = note_dao.getAllNotes();

    }

    public void insert(note n){
       // new InsertnoteAsynctask(note_dao).execute(n);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                note_dao.insert(n);
            }
        });

    }
    public void update(note n){
        //new updatenoteAsynctask(note_dao).execute(n);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                note_dao.update(n);
            }
        });
    }
    public  void delete(note n){
       // new deletenoteAsynctask(note_dao).execute(n);

        executor.execute(new Runnable() {
            @Override
            public void run() {
                note_dao.delete(n);
            }
        });
    }

    public LiveData<List<note>> getAllnote(){
        return notes;
    }
/*
    private static class InsertnoteAsynctask extends AsyncTask<note,Void,Void>{

        private not_dao dao;
        private InsertnoteAsynctask(not_dao dao){
            this.dao=dao;
        }
        @Override
        protected Void doInBackground(note... notes) {
            dao.insert(notes[0]);
            return null;
        }
    }


    private static class deletenoteAsynctask extends AsyncTask<note,Void,Void>{

        private not_dao dao;
        private  deletenoteAsynctask(not_dao dao){
            this.dao=dao;
        }
        @Override
        protected Void doInBackground(note... notes) {
            dao.delete(notes[0]);
            return null;
        }
    }

    private static class updatenoteAsynctask extends AsyncTask<note,Void,Void>{

        private not_dao dao;
        private updatenoteAsynctask(not_dao dao){
            this.dao=dao;
        }
        @Override
        protected Void doInBackground(note... notes) {
            dao.update(notes[0]);
            return null;
        }
    }
*/

}
