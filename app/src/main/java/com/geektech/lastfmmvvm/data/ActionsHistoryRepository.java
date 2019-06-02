package com.geektech.lastfmmvvm.data;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActionsHistoryRepository {
    private MutableLiveData<List<Pair<String, Date>>> actionsHistoryLiveData = new MutableLiveData<>();
    private ArrayList<Pair<String,Date>> actionsHistory = new ArrayList<>();

    public void addAction(String action) {
        actionsHistory.add(new Pair<>(action, new Date()));
        actionsHistoryLiveData.setValue(actionsHistory);
    }

    public LiveData<List<Pair<String, Date>>> getActionsHistoryLiveData() {
        return actionsHistoryLiveData;
    }
}
