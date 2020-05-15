package com.example.nbaseasonstats.interactor.events;

import com.example.nbaseasonstats.model.Player;

import java.util.ArrayList;
import java.util.List;

public class GetPlayersFromDbEvent {

    private List<Player> players = new ArrayList<Player>();
    private Throwable throwable;

    public GetPlayersFromDbEvent() {}

    public GetPlayersFromDbEvent(List<Player> players, Throwable throwable){
        this.players = players;
        this.throwable = throwable;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

}
