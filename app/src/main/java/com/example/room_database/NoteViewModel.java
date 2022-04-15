package com.example.room_database;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

/**
 * Created by Md Minhajul Islam on 4/15/2022.
 */
public class NoteViewModel extends AndroidViewModel {
    private String TAG = this.getClass().getSimpleName();
    private NoteDao noteDao;
    private NoteRoomDatabase noteDB;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteDB = NoteRoomDatabase.getDatabase(application);
        noteDao = noteDB.noteDao();
    }

    public void insert(Note note){
        new InsertAsyncTask(noteDao).execute(note);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.i(TAG,"ViewModel Destroyed");
    }

    private class InsertAsyncTask extends AsyncTask<Note,Void, Void>{
        NoteDao mnoteDao;

        public InsertAsyncTask(NoteDao noteDao) {
            this.mnoteDao = noteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            mnoteDao.insert(notes[0]);
            return null;
        }
    }
}
