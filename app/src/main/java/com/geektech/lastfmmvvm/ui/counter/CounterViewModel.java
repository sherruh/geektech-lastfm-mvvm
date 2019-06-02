package com.geektech.lastfmmvvm.ui.counter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;
import android.util.Pair;

import com.geektech.lastfmmvvm.App;
import com.geektech.lastfmmvvm.data.ActionsHistoryRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CounterViewModel extends ViewModel {

    MutableLiveData<Integer> counter = new MutableLiveData<>();
    ActionsHistoryRepository actionsHistoryRepository = App.actionsHistoryRepository;
    LiveData<List<Pair<String,Date>>> actionsHistory;

    public CounterViewModel() {
        counter.setValue(0);
        actionsHistoryRepository.addAction("init");
        actionsHistory = actionsHistoryRepository.getActionsHistoryLiveData();

    }


    void increment() {
        actionsHistoryRepository.addAction("increment");
        counter.setValue(counter.getValue() + 1);
    }

    void decrement() {
        actionsHistoryRepository.addAction("decrement");
        counter.setValue(counter.getValue() - 1);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("ololo", "ViewModel cleared");
    }

}
