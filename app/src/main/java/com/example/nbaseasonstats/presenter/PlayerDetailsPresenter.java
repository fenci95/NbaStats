package com.example.nbaseasonstats.presenter;

import android.renderscript.ScriptIntrinsicYuvToRGB;

import com.example.nbaseasonstats.interactor.PlayersInteractor;
import com.example.nbaseasonstats.view.PlayerDetailsScreen;

import javax.inject.Inject;

public class PlayerDetailsPresenter extends Presenter<PlayerDetailsScreen> {

    PlayersInteractor playersInteractor;

    @Inject
    public PlayerDetailsPresenter( PlayersInteractor playersInteractor) {
        this.playersInteractor = playersInteractor;
    }

    @Override
    public void attachScreen(PlayerDetailsScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }
}
