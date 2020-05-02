package com.example.nbaseasonstats.interactor;

import android.os.StrictMode;

import com.example.nbaseasonstats.model.Player;
import com.example.nbaseasonstats.model.PlayerList;
import com.example.nbaseasonstats.network.PlayersAPI;

import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Response;

public class PlayersInteractor {

    PlayersAPI playersAPI;

    @Inject
    public PlayersInteractor(PlayersAPI playersAPI) {
        this.playersAPI = playersAPI;
    }


    public void getPlayers() {
        try {
            Call<PlayerList> playersCall = playersAPI.playersGet();
            Response<PlayerList> response = playersCall.execute();
        } catch (Exception e) {

        }
    }

    public void getPlayerStats(Integer playerId) {
        try {
            Call<Player> playerCall = playersAPI.seasonAveragesGet(playerId);
            Response<Player> response = playerCall.execute();
        } catch (Exception e) {

        }
    }

}
