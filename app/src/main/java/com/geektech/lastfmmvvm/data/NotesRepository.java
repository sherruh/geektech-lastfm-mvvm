package com.geektech.lastfmmvvm.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class NotesRepository {

    private MutableLiveData<List<String>> notesLiveData = new MutableLiveData<>();
    private ArrayList<String> notes = new ArrayList<>();

    public LiveData<List<String>> getNotes() {
        return notesLiveData;
    }

    public void addNote(String note) {
        notes.add(note);
        notesLiveData.setValue(notes);
        Log.d("ololo",note);
    }

    public String getNote(int position) {
        return notes.get(position);
    }
}
