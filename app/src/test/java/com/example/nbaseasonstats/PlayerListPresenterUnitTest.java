package com.example.nbaseasonstats;

import com.example.nbaseasonstats.di.Network;
import com.example.nbaseasonstats.interactor.DatabaseInteractor;
import com.example.nbaseasonstats.interactor.PlayersInteractor;
import com.example.nbaseasonstats.interactor.events.GetPlayersEvent;
import com.example.nbaseasonstats.interactor.events.GetPlayersFromDbEvent;
import com.example.nbaseasonstats.interactor.events.InsertPlayersToDbEvent;
import com.example.nbaseasonstats.interactor.events.UpdatePlayerDbEvent;
import com.example.nbaseasonstats.model.Player;
import com.example.nbaseasonstats.presenter.PlayerListPresenter;
import com.example.nbaseasonstats.view.PlayerListScreen;

import org.greenrobot.eventbus.EventBus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.concurrent.Executors;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerListPresenterUnitTest {

    @Mock
    PlayersInteractor playersInteractor;
    @Mock
    DatabaseInteractor databaseInteractor;
    @Mock
    PlayerListScreen screen;
    PlayerListPresenter presenter;
    MockData mocks;

    @Before
    public void setup() {
        presenter = new PlayerListPresenter(Executors.newFixedThreadPool(1), playersInteractor, EventBus.getDefault(), databaseInteractor);
        presenter.attachScreen(screen);
        mocks = new MockData();
    }

    @After
    public void setdown() {
        presenter.detachScreen();
    }

    @Test
    public void getPlayer() {
        GetPlayersEvent event = new GetPlayersEvent();
        event.setPlayers(mocks.getPlayersFromApiMock());

        presenter.getPlayers();
        presenter.onEventMainThread(event);

        verify(playersInteractor).getPlayers();
    }

    @Test
    public void getPlayerError() {
        GetPlayersEvent event = new GetPlayersEvent();
        event.setPlayers(mocks.getPlayersFromApiMock());
        event.setThrowable(new Exception());

        presenter.getPlayers();
        presenter.onEventMainThread(event);

        verify(playersInteractor).getPlayers();
        verify(screen).showError(event.getThrowable());
    }

    @Test
    public void getPlayerFromDb() {
        GetPlayersFromDbEvent event = new GetPlayersFromDbEvent();
        List<Player> players = mocks.getPlayersFromDbMock();
        event.setPlayers(players);

        presenter.getPlayersFromDb();
        presenter.onEventMainThread(event);

        verify(databaseInteractor).getPlayersFromDb();
        verify(screen).showPlayers(players);
    }

    @Test
    public void getPlayerFromDbError() {
        GetPlayersFromDbEvent event = new GetPlayersFromDbEvent();
        List<Player> players = mocks.getPlayersFromDbMock();
        event.setPlayers(players);
        event.setThrowable(new Exception());

        presenter.getPlayersFromDb();
        presenter.onEventMainThread(event);

        verify(databaseInteractor).getPlayersFromDb();
        verify(screen).showError(event.getThrowable());
    }

    @Test
    public void updatePlayer() {
        UpdatePlayerDbEvent event = new UpdatePlayerDbEvent();
        event.setDone(true);
        Player player = mocks.getPlayerMock(1);

        presenter.updatePlayerDb(player);
        presenter.onEventMainThread(event);

        verify(databaseInteractor).updatePlayerDb(player);
    }

    @Test
    public void updatePlayerError() {
        UpdatePlayerDbEvent event = new UpdatePlayerDbEvent();
        event.setDone(false);
        event.setThrowable(new Exception());
        Player player = mocks.getPlayerMock(1);

        presenter.updatePlayerDb(player);
        presenter.onEventMainThread(event);

        verify(databaseInteractor).updatePlayerDb(player);
        verify(screen).showError(event.getThrowable());
    }

    @Test
    public void insertPlayers() {
        InsertPlayersToDbEvent event = new InsertPlayersToDbEvent();
        event.setDone(true);
        List<Player> players = mocks.getPlayersFromDbMock();

        presenter.insertPlayersToDb(players);
        presenter.onEventMainThread(event);

        verify(databaseInteractor).insertPlayersDb(players);
    }

    @Test
    public void insertPlayerError() {
        InsertPlayersToDbEvent event = new InsertPlayersToDbEvent();
        event.setDone(false);
        event.setThrowable(new Exception());
        List<Player> players = mocks.getPlayersFromDbMock();

        presenter.insertPlayersToDb(players);
        presenter.onEventMainThread(event);

        verify(databaseInteractor).insertPlayersDb(players);
        verify(screen).showError(event.getThrowable());
    }
}
