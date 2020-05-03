package com.example.nbaseasonstats.interactor.events;

import com.example.nbaseasonstats.model.PlayerList;

public class GetPlayersEvent {
    private int code;
    private PlayerList players;
    private Throwable throwable;

    public GetPlayersEvent() {

    }

    public GetPlayersEvent(int code, PlayerList players, Throwable throwable) {
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

    public PlayerList getPlayers() {
        return players;
    }

    public void setPlayers(PlayerList players) {
        this.players = players;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
