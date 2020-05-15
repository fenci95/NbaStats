package com.example.nbaseasonstats.presenter;

import com.example.nbaseasonstats.di.Network;
import com.example.nbaseasonstats.interactor.DatabaseInteractor;
import com.example.nbaseasonstats.interactor.PlayersInteractor;
import com.example.nbaseasonstats.interactor.events.GetPlayersEvent;
import com.example.nbaseasonstats.interactor.events.GetPlayersFromDbEvent;
import com.example.nbaseasonstats.interactor.events.InsertPlayersToDbEvent;
import com.example.nbaseasonstats.interactor.events.UpdatePlayerDbEvent;
import com.example.nbaseasonstats.model.Player;
import com.example.nbaseasonstats.model.PlayerListItemResponse;
import com.example.nbaseasonstats.view.PlayerListScreen;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class PlayerListPresenter extends Presenter<PlayerListScreen> {

    PlayersInteractor playersInteractor;
    Executor networkExecutor;
    EventBus bus;
    DatabaseInteractor databaseInteractor;

    @Inject
    public PlayerListPresenter(@Network Executor networkExecutor, PlayersInteractor playersInteractor, EventBus bus, DatabaseInteractor databaseInteractor) {
        this.playersInteractor = playersInteractor;
        this.networkExecutor = networkExecutor;
        this.databaseInteractor = databaseInteractor;
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

    public void getPlayersFromDb() {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                databaseInteractor.getPlayersFromDb();
            }
        });
    }

    public void updatePlayerDb(Player player) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                databaseInteractor.updatePlayerDb(player);
            }
        });
    }

    public void insertPlayersToDb(List<Player> players) {
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                databaseInteractor.insertPlayersDb(players);
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
            List<Player> players = new ArrayList<Player>();
            for (PlayerListItemResponse pr : event.getPlayers()) {
                Player player = pr.convertToPlayer();
                players.add(player);
            }
            insertPlayersToDb(players);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(GetPlayersFromDbEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showError(event.getThrowable());
            }
        } else {
            if (event.getPlayers().isEmpty()) {
                getPlayers();
            } else {
                if (screen != null) {
                    List<Player> players = event.getPlayers();
                    Collections.sort(players, new Comparator<Player>() {
                        @Override
                        public int compare(Player p1, Player p2) {
                            return Boolean.compare(p2.isFavourite, p1.isFavourite);
                        }
                    });
                    screen.showPlayers(event.getPlayers());
                }
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(InsertPlayersToDbEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showError(event.getThrowable());
            }
        } else {
            getPlayersFromDb();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(UpdatePlayerDbEvent event) {
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showError(event.getThrowable());
            }
        } else {
            getPlayersFromDb();
        }
    }

}
