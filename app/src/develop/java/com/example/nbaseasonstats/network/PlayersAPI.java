package com.example.nbaseasonstats.network;

import com.example.nbaseasonstats.model.PlayerResponse;
import com.example.nbaseasonstats.model.PlayerListResponse;

import retrofit2.http.*;
import retrofit2.Call;


public interface PlayersAPI {

    @GET("players")
    Call<PlayerListResponse> playersGet(
            @Query("page") Integer page
    );

    @GET("season_averages")
    Call<PlayerResponse> seasonAveragesGet(
            @Query("player_ids[]") Integer playerIds
    );
}
