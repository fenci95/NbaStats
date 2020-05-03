package com.example.nbaseasonstats.interactor;

import com.example.nbaseasonstats.database.NBAPlayerDao;
import com.example.nbaseasonstats.interactor.events.GetPlayersFromDbEvent;
import com.example.nbaseasonstats.model.Player;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DatabaseInteractor {

    NBAPlayerDao dao;
    EventBus bus;

    @Inject
    public DatabaseInteractor(NBAPlayerDao dao, EventBus bus) {
        this.dao = dao;
        this.bus = bus;
    }

    public void getPlayersFromDb() {
        GetPlayersFromDbEvent event = new GetPlayersFromDbEvent();
        try {
            List<Player> players = new ArrayList<Player>();
            players = dao.getAll();
            event.setPlayers(players);
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void insertPlayersDb(List<Player> players) {
        try {
            this.dao.insertAll(players);
        } catch (Exception e) {

        }
    }
}
