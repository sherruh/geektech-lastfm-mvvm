package com.geektech.lastfmmvvm.ui.notes;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.geektech.lastfmmvvm.App;
import com.geektech.lastfmmvvm.data.NotesRepository;

import java.util.List;

public class NotesViewModel extends ViewModel {
    LiveData<List<String>> notes;
    private NotesRepository repository = App.notesRepository;

    public NotesViewModel() {
        this.notes = repository.getNotes();
    }

    void addNote(String note) {
        repository.addNote(note);
    }
}
