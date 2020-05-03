package com.example.nbaseasonstats.view;

import com.example.nbaseasonstats.model.PlayerListResponse;

public interface PlayerListScreen {
    void showPlayers(PlayerListResponse players);
    void showError(Throwable throwable);
}
