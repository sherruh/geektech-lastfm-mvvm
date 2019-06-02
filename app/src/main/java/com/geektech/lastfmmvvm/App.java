package com.geektech.lastfmmvvm;

import android.app.Application;

import com.geektech.lastfmmvvm.data.ActionsHistoryRepository;
import com.geektech.lastfmmvvm.data.NotesRepository;

public class App extends Application {
    public static NotesRepository notesRepository;
    public static ActionsHistoryRepository actionsHistoryRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        notesRepository = new NotesRepository();
        actionsHistoryRepository = new ActionsHistoryRepository();
    }
}
