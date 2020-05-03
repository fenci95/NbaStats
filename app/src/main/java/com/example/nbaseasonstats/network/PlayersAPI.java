package com.example.nbaseasonstats.network;

import com.example.nbaseasonstats.model.Player;
import com.example.nbaseasonstats.model.PlayerList;

import retrofit2.http.*;
import retrofit2.Call;


public interface PlayersAPI {

    @GET("players")
    Call<PlayerList> playersGet();

    @GET("season_averages")
    Call<Player> seasonAveragesGet(
            @Query("player_ids[]") Integer playerIds
    );
}
