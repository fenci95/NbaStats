package com.example.nbaseasonstats.model;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {

    private List<PlayerListItem> players = new ArrayList<PlayerListItem>();

    public List<PlayerListItem> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerListItem> players) {
        this.players = players;
    }
}
