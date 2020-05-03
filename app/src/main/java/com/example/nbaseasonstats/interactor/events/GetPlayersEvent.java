package com.example.nbaseasonstats.interactor.events;

import com.example.nbaseasonstats.model.PlayerListResponse;

public class GetPlayersEvent {
    private int code;
    private PlayerListResponse players;
    private Throwable throwable;

    public GetPlayersEvent() {

    }

    public GetPlayersEvent(int code, PlayerListResponse players, Throwable throwable) {
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

    public PlayerListResponse getPlayers() {
        return players;
    }

    public void setPlayers(PlayerListResponse players) {
        this.players = players;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
