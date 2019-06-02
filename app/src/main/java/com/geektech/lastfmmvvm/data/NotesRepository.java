package com.geektech.lastfmmvvm.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.geektech.lastfmmvvm.entity.Note;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotesRepository {

    private MutableLiveData<List<Note>> notesLiveData = new MutableLiveData<>();
    private ArrayList<Note> notes = new ArrayList<>();

    public LiveData<List<Note>> getNotes() {
        return notesLiveData;
    }

    public void addNote(String note) {
        notes.add(new Note(note,new Date()));
        notesLiveData.setValue(notes);
        Log.d("ololo",note);
    }

    public Note getNote(int position) {
        return notes.get(position);
    }
}
