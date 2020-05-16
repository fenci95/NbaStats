package com.example.nbaseasonstats;

import com.example.nbaseasonstats.interactor.PlayersInteractor;
import com.example.nbaseasonstats.interactor.events.GetPlayerStatsEvent;
import com.example.nbaseasonstats.interactor.events.GetPlayersEvent;
import com.example.nbaseasonstats.interactor.events.GetPlayersFromDbEvent;
import com.example.nbaseasonstats.network.PlayersAPI;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayersInteractorUnitTest {

    private PlayersInteractor interactor;
    private EventBus eventbus;
    private MockData mocks = new MockData();
    @Mock
    PlayersAPI playersAPI;

    private GetPlayerCallback playersCallback;
    private GetPlayerStatCallback playerStatCallback;

    public abstract class GetPlayerCallback {
        abstract void onSuccess(GetPlayersEvent event);
    }

    public abstract class GetPlayerStatCallback {
        abstract void onSuccess(GetPlayerStatsEvent event);
    }

    @Before
    public void setup() {
        eventbus = EventBus.getDefault();
        eventbus.register(this);
        interactor = new PlayersInteractor(playersAPI, eventbus);
    }

    @After
    public void setdown() {
        eventbus.unregister(this);
    }

    @Test
    public void  getPlayerStatsFromNewtworkError() {
        playerStatCallback = new GetPlayerStatCallback() {
            @Override
            public  void onSuccess(GetPlayerStatsEvent event){
                Assert.assertNotNull(event);
                Assert.assertEquals(event.getThrowable().getMessage(), "Network error");
            }
        };

        when(playersAPI.seasonAveragesGet(210)).thenAnswer(invocation -> { throw new Exception("Network error"); });
        interactor.getPlayerStats(210);

        verify(playersAPI).seasonAveragesGet(210);
    }

    @Test
    public void  getAllPlayerFromNewtworkError() {
        playersCallback = new GetPlayerCallback() {
            @Override
            public  void onSuccess(GetPlayersEvent event){
                Assert.assertNotNull(event);
                Assert.assertEquals(event.getThrowable().getMessage(), "Network error");
            }
        };

        when(playersAPI.playersGet(120)).thenAnswer(invocation -> { throw new Exception("Network error"); });
        interactor.getPlayers();

        verify(playersAPI).playersGet(120);
    }

    @Subscribe
    public void onEventMainThread(GetPlayersEvent event) {
        playersCallback.onSuccess(event);
    }

    @Subscribe
    public void onEventMainThread(GetPlayerStatsEvent event) {
        playerStatCallback.onSuccess(event);
    }

}
