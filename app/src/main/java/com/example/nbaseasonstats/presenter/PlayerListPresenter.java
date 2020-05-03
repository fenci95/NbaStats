package com.example.nbaseasonstats.presenter;

import com.example.nbaseasonstats.di.Network;
import com.example.nbaseasonstats.interactor.PlayersInteractor;
import com.example.nbaseasonstats.interactor.events.GetPlayersEvent;
import com.example.nbaseasonstats.view.PlayerListScreen;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class PlayerListPresenter extends Presenter<PlayerListScreen> {

    PlayersInteractor playersInteractor;
    Executor networkExecutor;
    EventBus bus;

    @Inject
    public PlayerListPresenter(@Network Executor networkExecutor, PlayersInteractor playersInteractor, EventBus bus) {
        this.playersInteractor = playersInteractor;
        this.networkExecutor = networkExecutor;
        this.bus = bus;
    }

    @Override
    public void attachScreen(PlayerListScreen screen) {
        super.attachScreen(screen);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    public void getPlayers() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                playersInteractor.getPlayers();
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(GetPlayersEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showError(event.getThrowable());
            }
        } else {
            if (screen != null) {
                screen.showPlayers(event.getPlayers());
            }
        }
    }
}
