package com.note.myapplication.mvvm;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

/**
 * View Model to keep a reference to the note repository and
 * an up-to-date list of all notes.
 */

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository mRepository;
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    private LiveData<List<Notice>> mAllNotes;

    public NoteViewModel(Application application) {
        super(application);
        mRepository = new NoteRepository(application);
        mAllNotes = mRepository.getAllNotes();
    }

    public LiveData<List<Notice>> getAllNotes() {
        return mAllNotes;
    }

    void insert(Notice note) {
        mRepository.insert(note);
    }
}
