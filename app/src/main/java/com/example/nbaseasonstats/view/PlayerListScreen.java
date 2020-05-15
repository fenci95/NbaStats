package com.example.nbaseasonstats.view;

import com.example.nbaseasonstats.model.Player;
import com.example.nbaseasonstats.model.PlayerListResponse;

import java.util.List;

public interface PlayerListScreen {
    void showPlayers(List<Player> players);
    void showError(Throwable throwable);
}
