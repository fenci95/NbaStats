package com.example.nbaseasonstats.presenter;

import com.example.nbaseasonstats.di.Network;
import com.example.nbaseasonstats.interactor.PlayersInteractor;
import com.example.nbaseasonstats.model.PlayerList;
import com.example.nbaseasonstats.view.PlayerListScreen;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class PlayerListPresenter extends Presenter<PlayerListScreen> {

    PlayersInteractor playersInteractor;
    Executor networkExecutor;

    @Inject
    public PlayerListPresenter(@Network Executor networkExecutor, PlayersInteractor playersInteractor) {
        this.playersInteractor = playersInteractor;
        this.networkExecutor = networkExecutor;
    }

    public void getPlayers() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                playersInteractor.getPlayers();
            }
        });
    }

    public  void getPlayerStatistics(Integer playerId) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                playersInteractor.getPlayerStats(playerId);
            }
        });
    }

    @Override
    public void attachScreen(PlayerListScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
