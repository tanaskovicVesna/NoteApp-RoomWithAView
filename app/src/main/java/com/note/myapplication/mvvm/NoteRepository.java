package com.note.myapplication.mvvm;

import android.app.Application;

import androidx.lifecycle.LiveData;


import java.util.List;

class NoteRepository {
    private NoticeDao mNoteDao;
    private LiveData<List<Notice>> mAllNotes;

    NoteRepository(Application application) {
        NoteRoomDatabase db = NoteRoomDatabase.getDatabase(application);
        mNoteDao = db.noteDao();
        mAllNotes = mNoteDao.getAlphabetizedNotes();
    }

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    LiveData<List<Notice>> getAllNotes() {
        return mAllNotes;
    }

    // You must call this on a non-UI thread or your app will throw an exception. Room ensures
    // that you're not doing any long running operations on the main thread, blocking the UI.
    void insert(Notice note) {
        NoteRoomDatabase.databaseWriteExecutor.execute(() -> {
            mNoteDao.insert(note);
        });
    }

}
