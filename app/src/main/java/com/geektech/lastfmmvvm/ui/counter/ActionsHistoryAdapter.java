package com.geektech.lastfmmvvm.ui.counter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActionsHistoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Pair<String, Date>> mActions;

    public ActionsHistoryAdapter(ArrayList<Pair<String, Date>> actions) {
        this.mActions = actions;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //TODO: Return ViewHolder
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        //TODO: Refresh ViewHolder data

        if (mActions.size() > i && i >= 0) {
            mActions.get(i);
        }
    }

    @Override
    public int getItemCount() {
        return mActions.size();
    }

    public void setActions(List<Pair<String, Date>> actions) {
        mActions.clear();
        mActions.addAll(actions);
        notifyDataSetChanged();
    }
}
