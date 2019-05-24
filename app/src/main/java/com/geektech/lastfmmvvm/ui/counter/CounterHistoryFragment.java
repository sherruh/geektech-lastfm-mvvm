package com.geektech.lastfmmvvm.ui.counter;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.lastfmmvvm.R;

import java.util.Date;

public class CounterHistoryFragment extends Fragment {

    private CounterViewModel mViewModel;

    public static CounterHistoryFragment newInstance() {
        return new CounterHistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.history_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() == null) return;

        mViewModel = ViewModelProviders.of(getActivity())
                .get(CounterViewModel.class);

        mViewModel.counter.observe(this, integer ->
                Log.d("ololo", "History counter " + integer)
        );

        mViewModel.actionsHistory.observe(this, pairs -> {
            for (Pair<String, Date> pair : pairs) {
                Log.d("ololo", pair.toString());
            }
        });
    }

}
