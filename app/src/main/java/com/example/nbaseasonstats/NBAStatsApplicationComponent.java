package com.example.nbaseasonstats;

import com.example.nbaseasonstats.view.PlayerDetailsActivity;
import com.example.nbaseasonstats.view.PlayerListActivity;
import com.example.nbaseasonstats.view.UIModule;
import com.example.nbaseasonstats.interactor.InteractorModule;
import com.example.nbaseasonstats.presenter.PresenterModule;
import com.example.nbaseasonstats.network.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class, PresenterModule.class, NetworkModule.class })
public interface NBAStatsApplicationComponent {
    void inject(PlayerListActivity playerListActivityActivity);
    void inject(PlayerDetailsActivity playerDetailsActivity);
}
