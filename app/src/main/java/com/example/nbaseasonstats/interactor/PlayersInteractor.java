package com.example.nbaseasonstats.interactor;

import com.example.nbaseasonstats.interactor.events.GetPlayerStatsEvent;
import com.example.nbaseasonstats.interactor.events.GetPlayersEvent;
import com.example.nbaseasonstats.model.PlayerResponse;
import com.example.nbaseasonstats.model.PlayerListResponse;
import com.example.nbaseasonstats.network.PlayersAPI;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Response;

public class PlayersInteractor {

    PlayersAPI playersAPI;

    EventBus bus;

    @Inject
    public PlayersInteractor(PlayersAPI playersAPI, EventBus bus) {
        this.playersAPI = playersAPI;
        this.bus = bus;
    }


    public void getPlayers() {
        GetPlayersEvent event = new GetPlayersEvent();
        try {
            Call<PlayerListResponse> playersCall = playersAPI.playersGet();
            Response<PlayerListResponse> response = playersCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setPlayers(response.body());
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

    public void getPlayerStats(Integer playerId) {
        GetPlayerStatsEvent event = new GetPlayerStatsEvent();
        try {
            Call<PlayerResponse> playerCall = playersAPI.seasonAveragesGet(playerId);
            Response<PlayerResponse> response = playerCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setPlayer(response.body());
            bus.post(event);
        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(event);
        }
    }

}
