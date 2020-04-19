package com.example.nbaseasonstats.presenter;

import com.example.nbaseasonstats.interactor.PlayersInteractor;
import com.example.nbaseasonstats.view.PlayerListScreen;

import javax.inject.Inject;

public class PlayerListPresenter extends Presenter<PlayerListScreen> {

    PlayersInteractor playersInteractor;

    @Inject
    public PlayerListPresenter( PlayersInteractor playersInteractor) {
        this.playersInteractor = playersInteractor;
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
