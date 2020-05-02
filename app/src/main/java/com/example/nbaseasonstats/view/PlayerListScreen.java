package com.example.nbaseasonstats.view;

import com.example.nbaseasonstats.model.PlayerList;

public interface PlayerListScreen {
    void showPlayers(PlayerList players);
    void showError(Throwable throwable);
}
