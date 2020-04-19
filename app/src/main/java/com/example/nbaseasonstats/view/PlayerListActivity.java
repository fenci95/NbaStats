package com.example.nbaseasonstats.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.nbaseasonstats.R;

public class PlayerListActivity extends AppCompatActivity implements PlayerListScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    public void showPlayers() {

    }
}
