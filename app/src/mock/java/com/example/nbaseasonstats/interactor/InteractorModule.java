package com.example.nbaseasonstats.interactor;

import org.greenrobot.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class InteractorModule {
    @Provides
    @Singleton
    public PlayersInteractor providePlayersInteractor(EventBus bus){
        return new PlayersInteractor(bus);
    }

    @Provides
    @Singleton
    public DatabaseInteractor provideDatabaseInteractor(EventBus bus){
        return new DatabaseInteractor(bus);
    }
}
