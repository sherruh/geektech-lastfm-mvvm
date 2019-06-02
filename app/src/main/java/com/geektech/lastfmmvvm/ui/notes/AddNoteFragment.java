package com.geektech.lastfmmvvm.ui.notes;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.geektech.lastfmmvvm.R;
import com.geektech.lastfmmvvm.entity.Note;

import java.util.List;

public class AddNoteFragment extends Fragment {
    private NotesViewModel mViewModel;
    private Button buttonSave;
    private TextInputEditText inputNote;

    public static Fragment newInstance() {
        return new AddNoteFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (getActivity() == null) return;

        mViewModel = ViewModelProviders.of(getActivity())
                .get(NotesViewModel.class);

        mViewModel.notes.observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> strings) {
                Log.d("ololo", "Notes changed");
            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.addnote_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        inputNote = view.findViewById(R.id.input_note_name);
        buttonSave = view.findViewById(R.id.button_save);
        buttonSave.setOnClickListener(v -> {
           mViewModel.addNote(inputNote.getText().toString().trim());
           inputNote.setText("");
           inputNote.setHint("Name");
        });
    }
}
