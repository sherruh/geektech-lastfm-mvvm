package com.geektech.lastfmmvvm.ui.counter;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CounterViewModel extends ViewModel {

    MutableLiveData<Integer> counter = new MutableLiveData<>();

    MutableLiveData<List<Pair<String, Date>>> actionsHistory = new MutableLiveData<>();
    private ArrayList<Pair<String, Date>> history = new ArrayList<>();

    public CounterViewModel() {
        counter.setValue(0);

        history.add(new Pair<>("init", new Date()));
        actionsHistory.setValue(history);
    }

    private void addAction(String action) {
        history.add(new Pair<>(action, new Date()));
        actionsHistory.setValue(history);
    }

    void increment() {
        addAction("increment");
        counter.setValue(counter.getValue() + 1);
    }

    void decrement() {
        addAction("decrement");
        counter.setValue(counter.getValue() - 1);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("ololo", "ViewModel cleared");
    }

}
