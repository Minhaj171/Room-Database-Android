package com.example.room_database;

import androidx.room.Dao;
import androidx.room.Insert;

/**
 * Created by Md Minhajul Islam on 4/15/2022.
 */

@Dao
public interface NoteDao {
    @Insert
    void insert(Note note);
}
