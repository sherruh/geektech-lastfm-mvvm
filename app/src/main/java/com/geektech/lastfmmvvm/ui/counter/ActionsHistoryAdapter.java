package com.geektech.lastfmmvvm.ui.counter;

import android.drm.DrmStore;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geektech.lastfmmvvm.R;

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
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.history_view_holder, viewGroup, false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (mActions.size() > i && i >= 0) {
            ((HistoryViewHolder)viewHolder).onBind(mActions.get(i));
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

    public class HistoryViewHolder extends RecyclerView.ViewHolder{

        private TextView textDate;
        private TextView textAction;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            textDate = itemView.findViewById(R.id.text_date);
            textAction = itemView.findViewById(R.id.text_action);
        }

        public void onBind(Pair<String,Date> action){
            textAction.setText(action.first);
            textDate.setText(action.second.toString());
        }
    }
}
