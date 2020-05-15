package com.example.nbaseasonstats.presenter;

import com.example.nbaseasonstats.di.Network;
import com.example.nbaseasonstats.interactor.DatabaseInteractor;
import com.example.nbaseasonstats.interactor.PlayersInteractor;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    PlayerListPresenter providePlayerListPresenter(@Network Executor networkExecutor, PlayersInteractor playersInteractor, EventBus bus, DatabaseInteractor databaseInteractor) {
        return new PlayerListPresenter(networkExecutor, playersInteractor, bus, databaseInteractor);
    }

    @Provides
    @Singleton
    PlayerDetailsPresenter providePlayerDetailsPresenter(@Network Executor networkExecutor, PlayersInteractor playersInteractor, EventBus bus) {
        return new PlayerDetailsPresenter(networkExecutor, playersInteractor, bus);
    }
}
