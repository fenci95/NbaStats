package com.example.nbaseasonstats.presenter;

import com.example.nbaseasonstats.di.Network;
import com.example.nbaseasonstats.interactor.PlayersInteractor;

import java.util.concurrent.Executor;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    PlayerListPresenter providePlayerListPresenter(@Network Executor networkExecutor, PlayersInteractor playersInteractor) {
        return new PlayerListPresenter(networkExecutor, playersInteractor);
    }

    @Provides
    @Singleton
    PlayerDetailsPresenter providePlayerDetailsPresenter(PlayersInteractor playersInteractor) {
        return new PlayerDetailsPresenter(playersInteractor);
    }
}
