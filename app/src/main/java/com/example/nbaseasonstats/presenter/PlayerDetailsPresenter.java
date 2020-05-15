package com.example.nbaseasonstats.presenter;

import android.renderscript.ScriptIntrinsicYuvToRGB;

import com.example.nbaseasonstats.di.Network;
import com.example.nbaseasonstats.interactor.PlayersInteractor;
import com.example.nbaseasonstats.interactor.events.GetPlayerStatsEvent;
import com.example.nbaseasonstats.interactor.events.GetPlayersEvent;
import com.example.nbaseasonstats.view.PlayerDetailsScreen;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class PlayerDetailsPresenter extends Presenter<PlayerDetailsScreen> {

    PlayersInteractor playersInteractor;
    Executor networkExecutor;
    EventBus bus;

    @Inject
    public PlayerDetailsPresenter(@Network Executor networkExecutor, PlayersInteractor playersInteractor, EventBus bus) {
        this.playersInteractor = playersInteractor;
        this.networkExecutor = networkExecutor;
        this.bus = bus;
    }

    public  void getPlayerStatistics(Integer playerId) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                playersInteractor.getPlayerStats(playerId);
            }
        });
    }

    @Override
    public void attachScreen(PlayerDetailsScreen screen) {
        super.attachScreen(screen);
        bus.register(this);
    }

    @Override
    public void detachScreen() {
        bus.unregister(this);
        super.detachScreen();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(GetPlayerStatsEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showError(event.getThrowable());
            }
        } else {
            if (screen != null) {
                screen.showStats(event.getPlayer());
            }
        }
    }
}
