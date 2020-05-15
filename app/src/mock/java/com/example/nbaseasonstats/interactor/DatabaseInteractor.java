package com.example.nbaseasonstats.interactor;

import com.example.nbaseasonstats.interactor.events.GetPlayersFromDbEvent;
import com.example.nbaseasonstats.interactor.events.InsertPlayersToDbEvent;
import com.example.nbaseasonstats.model.Player;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DatabaseInteractor {

    EventBus bus;

    @Inject
    public DatabaseInteractor(EventBus bus) {
        this.bus = bus;
    }

    public void getPlayersFromDb() {
        GetPlayersFromDbEvent event = new GetPlayersFromDbEvent();
        try {
            // event.setPlayers();
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void insertPlayersDb(List<Player> players) {
        InsertPlayersToDbEvent event = new InsertPlayersToDbEvent();
        try {
            event.setDone(true);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void updatePlayerDb(Player player) {

    }
}
