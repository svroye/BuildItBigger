package com.example.jokedisplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JokeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        if (savedInstanceState != null) {
            JokeFragment jokeFragment = new JokeFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.joke_fragment, jokeFragment)
                    .commit();
        }
    }
}
