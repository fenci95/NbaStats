package com.example.nbaseasonstats;

import com.example.nbaseasonstats.model.Player;
import com.example.nbaseasonstats.model.PlayerDetailsResponse;
import com.example.nbaseasonstats.model.PlayerListItemResponse;
import com.example.nbaseasonstats.model.PlayerResponse;

import java.util.ArrayList;
import java.util.List;

public class MockData {

    List<Player> getPlayersFromDbMock() {
        List<Player> playersMock = new ArrayList<>();
        playersMock.add(getPlayerMock(1));
        playersMock.add(getPlayerMock(2));
        playersMock.add(getPlayerMock(3));
        playersMock.add(getPlayerMock(4));
        return  playersMock;
    }

    Player getPlayerMock(long id) {
        Player player = new Player();
        player.id = id;
        player.firstName = "Kobe";
        player.lastName = "Bryant";
        player.isFavourite = true;
        return player;
    }

    List<PlayerListItemResponse> getPlayersFromApiMock() {
        List<PlayerListItemResponse> playersMock = new ArrayList<>();
        playersMock.add(getPlayerApiMock(1));
        playersMock.add(getPlayerApiMock(2));
        playersMock.add(getPlayerApiMock(3));
        playersMock.add(getPlayerApiMock(4));
        return  playersMock;
    }

    PlayerListItemResponse getPlayerApiMock(long id) {
        PlayerListItemResponse player = new PlayerListItemResponse();
        player.setId(id);
        player.setFirstName("Kobe");
        player.setLastName("Bryant");
        return player;
    }

    PlayerDetailsResponse getPlayerDetailsMock() {
        PlayerDetailsResponse resp = new PlayerDetailsResponse();
        resp.setAst(5.8);
        resp.setBlk(5.8);
        resp.setDreb(5.8);
        resp.setFg3m(5.8);
        resp.setFg3Pct(5.8);
        resp.setFgm(5.8);
        resp.setOreb(5.8);
        return  resp;
    }

    PlayerResponse getPlayerResponse() {
        PlayerResponse pr = new PlayerResponse();
        List<PlayerDetailsResponse> list = new ArrayList<>();
        list.add(getPlayerDetailsMock());
        pr.setData(list);
        return pr;
    }
}
