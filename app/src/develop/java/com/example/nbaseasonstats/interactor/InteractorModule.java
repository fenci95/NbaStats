package com.example.nbaseasonstats.interactor;

import com.example.nbaseasonstats.database.NBAPlayerDao;
import com.example.nbaseasonstats.network.PlayersAPI;

import org.greenrobot.eventbus.EventBus;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class InteractorModule {
    @Provides
    @Singleton
    public PlayersInteractor providePlayersInteractor(PlayersAPI api, EventBus bus){
        return new PlayersInteractor(api, bus);
    }

    @Provides
    @Singleton
    public DatabaseInteractor provideDatabaseInteractor(NBAPlayerDao dao, EventBus bus){
        return new DatabaseInteractor(dao, bus);
    }
}
