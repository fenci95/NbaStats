package com.example.nbaseasonstats.interactor.events;

import com.example.nbaseasonstats.model.Player;

public class GetPlayerStatsEvent {
    private int code;
    private Player player;
    private Throwable throwable;

    public GetPlayerStatsEvent() {

    }

    public GetPlayerStatsEvent(int code, Player player, Throwable throwable) {
        this.code = code;
        this.player = player;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}
