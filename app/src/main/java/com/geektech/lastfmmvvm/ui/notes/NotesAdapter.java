package com.geektech.lastfmmvvm.ui.notes;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geektech.lastfmmvvm.R;
import com.geektech.lastfmmvvm.ui.counter.ActionsHistoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<String> mNotes;

    public NotesAdapter(ArrayList<String> notes) {
        mNotes = notes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.note_view_holder, viewGroup, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (mNotes.size() > i && i >= 0) {
            ((NotesViewHolder)viewHolder).onBind(mNotes.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return mNotes.size();
    }

    public void setNotes(List<String> notes) {
        mNotes.clear();
        mNotes.addAll(notes);
        notifyDataSetChanged();
    }

    public class NotesViewHolder extends RecyclerView.ViewHolder{

        private TextView textName;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.text_note_name);
        }

        public void onBind(String note){
            textName.setText(note);
        }
    }
}
