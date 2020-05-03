package com.example.nbaseasonstats.interactor;

import com.example.nbaseasonstats.interactor.events.GetPlayerStatsEvent;
import com.example.nbaseasonstats.interactor.events.GetPlayersEvent;
import com.example.nbaseasonstats.model.PlayerResponse;
import com.example.nbaseasonstats.model.PlayerListResponse;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Response;

public class PlayersInteractor {

    EventBus bus;

    @Inject
    public PlayersInteractor(EventBus bus) {
        this.bus = bus;
    }


    public void getPlayers() {
        GetPlayersEvent event = new GetPlayersEvent();
        try {
            event.setCode(200);
            // event.setPlayers();
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getPlayerStats(Integer playerId) {
        GetPlayerStatsEvent event = new GetPlayerStatsEvent();
        try {
            event.setCode(200);
            // event.setPlayer();
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

}
