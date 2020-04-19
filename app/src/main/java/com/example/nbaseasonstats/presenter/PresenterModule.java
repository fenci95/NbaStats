package com.example.nbaseasonstats.presenter;

import com.example.nbaseasonstats.interactor.PlayersInteractor;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    PlayerListPresenter providePlayerListPresenter(PlayersInteractor playersInteractor) {
        return new PlayerListPresenter(playersInteractor);
    }

    @Provides
    @Singleton
    PlayerDetailsPresenter providePlayerDetailsPresenter(PlayersInteractor playersInteractor) {
        return new PlayerDetailsPresenter(playersInteractor);
    }
}
