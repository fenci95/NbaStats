package com.example.nbaseasonstats;

import com.example.nbaseasonstats.interactor.PlayersInteractor;
import com.example.nbaseasonstats.interactor.events.GetPlayerStatsEvent;
import com.example.nbaseasonstats.interactor.events.GetPlayersEvent;
import com.example.nbaseasonstats.model.PlayerResponse;
import com.example.nbaseasonstats.presenter.PlayerDetailsPresenter;
import com.example.nbaseasonstats.view.PlayerDetailsScreen;


import org.greenrobot.eventbus.EventBus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.concurrent.Executors;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class PlayerDetailsPresenterUnitTest {

    @Mock
    PlayersInteractor playersInteractor;
    @Mock
    PlayerDetailsScreen screen;
    PlayerDetailsPresenter presenter;
    MockData mocks;

    @Before
    public void setup() {
        presenter = new PlayerDetailsPresenter(Executors.newFixedThreadPool(1), playersInteractor, EventBus.getDefault());
        presenter.attachScreen(screen);
        mocks = new MockData();
    }

    @After
    public void setdown() {
        presenter.detachScreen();
    }

    @Test
    public void getPlayerStats() {
        GetPlayerStatsEvent event = new GetPlayerStatsEvent();
        PlayerResponse pr = mocks.getPlayerResponse();
        event.setPlayer(pr);

        presenter.getPlayerStatistics(20);
        presenter.onEventMainThread(event);

        verify(playersInteractor).getPlayerStats(20);
        verify(screen).showStats(event.getPlayer());
    }

    @Test
    public void getPlayerError() {
        GetPlayerStatsEvent event = new GetPlayerStatsEvent();
        PlayerResponse pr = mocks.getPlayerResponse();
        event.setPlayer(pr);
        event.setThrowable(new Exception());

        presenter.getPlayerStatistics(20);
        presenter.onEventMainThread(event);

        verify(playersInteractor).getPlayerStats(20);
        verify(screen).showError(event.getThrowable());
    }
}
