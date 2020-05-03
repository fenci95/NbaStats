package com.example.nbaseasonstats.view;

import com.example.nbaseasonstats.model.Player;

public interface PlayerDetailsScreen {
    void showStats(Player players);
    void showError(Throwable throwable);
}
