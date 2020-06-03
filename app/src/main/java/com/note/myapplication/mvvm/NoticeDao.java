package com.note.myapplication.mvvm;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import java.util.List;

@Dao
public interface NoticeDao {
    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.
    @Query("SELECT * from note_table ORDER BY note ASC")
    LiveData<List<Notice>> getAlphabetizedNotes();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Notice notice);

    @Query("DELETE FROM note_table")
    void deleteAll();
}
