package com.example.jokedisplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeFragment extends Fragment {

    public JokeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke, container, false);
        TextView jokeTv = rootView.findViewById(R.id.joke_textView);
        Intent intent = getActivity().getIntent();

        if (intent == null) return null;

        if (intent.hasExtra("joke")) {
            jokeTv.setText(intent.getStringExtra("joke"));
        }
        return rootView;
    }

}
