package com.example.room_database;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

/**
 * Created by Md Minhajul Islam on 4/16/2022.
 */
public class EditNoteViewModel extends AndroidViewModel {
    private String TAG = this.getClass().getSimpleName();
    private NoteDao noteDao;
    private NoteRoomDatabase db;

    public EditNoteViewModel(@NonNull Application application) {
        super(application);
        Log.i(TAG, "Edit ViewModel");
        db = NoteRoomDatabase.getDatabase(application);
        noteDao = db.noteDao();
    }

    public LiveData<Note> getNote(String noteId){
        return noteDao.getNote(noteId);
    }
}
