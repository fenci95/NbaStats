package com.example.nbaseasonstats.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.nbaseasonstats.NBAStatsApplication;
import com.example.nbaseasonstats.R;
import com.example.nbaseasonstats.model.PlayerListResponse;
import com.example.nbaseasonstats.presenter.PlayerListPresenter;

import javax.inject.Inject;

public class PlayerListActivity extends AppCompatActivity implements PlayerListScreen {

    @Inject
    PlayerListPresenter playerListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NBAStatsApplication.injector.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.playerListPresenter.attachScreen(this);
        this.playerListPresenter.getPlayers();
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.playerListPresenter.detachScreen();
    }

    @Override
    public void showPlayers(PlayerListResponse players) {

    }

    @Override
    public void showError(Throwable throwable) {
        Log.d("Error", throwable.getMessage());
    }
}
