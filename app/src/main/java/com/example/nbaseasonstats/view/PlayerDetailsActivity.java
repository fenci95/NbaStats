package com.example.nbaseasonstats.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nbaseasonstats.R;
import com.example.nbaseasonstats.presenter.PlayerDetailsPresenter;

public class PlayerDetailsActivity extends AppCompatActivity implements PlayerDetailsScreen {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_details);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
