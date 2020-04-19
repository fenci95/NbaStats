package com.example.nbaseasonstats.interactor;

import com.example.nbaseasonstats.network.PlayersAPI;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

@Module
public class InteractorModule {
    @Provides
    @Singleton
    public PlayersInteractor providePlayersInteractor(PlayersAPI api){
        return new PlayersInteractor(api);
    }
}
