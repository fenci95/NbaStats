package com.example.nbaseasonstats.interactor.events;

import com.example.nbaseasonstats.model.PlayerListItemResponse;
import com.example.nbaseasonstats.model.PlayerListResponse;

import java.util.ArrayList;
import java.util.List;

public class GetPlayersEvent {
    private int code;
    private List<PlayerListItemResponse> players = new ArrayList<PlayerListItemResponse>();
    private Throwable throwable;

    public GetPlayersEvent() {

    }

    public GetPlayersEvent(int code, List<PlayerListItemResponse> players, Throwable throwable) {
        this.code = code;
        this.players = players;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<PlayerListItemResponse> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerListItemResponse> players) {
        this.players = players;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
