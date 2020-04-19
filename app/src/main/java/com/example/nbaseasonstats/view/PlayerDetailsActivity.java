package com.example.nbaseasonstats.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nbaseasonstats.NBAStatsApplication;
import com.example.nbaseasonstats.R;
import com.example.nbaseasonstats.presenter.PlayerDetailsPresenter;

import javax.inject.Inject;

public class PlayerDetailsActivity extends AppCompatActivity implements PlayerDetailsScreen {

    @Inject
    PlayerDetailsPresenter playerDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_details);

        NBAStatsApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        playerDetailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        playerDetailsPresenter.detachScreen();
    }
}
