package com.geektech.lastfmmvvm.ui.notes;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class AddNoteFragment extends Fragment {
    private NotesViewModel mViewModel;

    public static Fragment newInstance() {
        return new AddNoteFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() == null) return;

        mViewModel = ViewModelProviders.of(getActivity())
                .get(NotesViewModel.class);

        mViewModel.notes.observe(this, new Observer<List<String>>() {
            @Override
            public void onChanged(@Nullable List<String> strings) {
                Log.d("ololo", "Notes changed");
            }
        });

        mViewModel.addNote("New note");
    }
}
