package com.example.nbaseasonstats.view;

import com.example.nbaseasonstats.model.PlayerResponse;

public interface PlayerDetailsScreen {
    void showStats(PlayerResponse players);
    void showError(Throwable throwable);
}
