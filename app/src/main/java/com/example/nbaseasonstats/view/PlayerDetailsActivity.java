package com.example.nbaseasonstats.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nbaseasonstats.NBAStatsApplication;
import com.example.nbaseasonstats.R;
import com.example.nbaseasonstats.model.Player;
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
        playerDetailsPresenter.getPlayerStatistics(237);
    }

    @Override
    protected void onStop() {
        super.onStop();
        playerDetailsPresenter.detachScreen();
    }

    @Override
    public void showStats(Player playerStats) {

    }

    @Override
    public void showError(Throwable throwable) {
        Log.d("Error", throwable.getMessage());
    }
}
