package com.example.nbaseasonstats;

import com.example.nbaseasonstats.database.NBAPlayerDao;
import com.example.nbaseasonstats.interactor.DatabaseInteractor;
import com.example.nbaseasonstats.interactor.events.GetPlayersFromDbEvent;
import com.example.nbaseasonstats.interactor.events.InsertPlayersToDbEvent;
import com.example.nbaseasonstats.interactor.events.UpdatePlayerDbEvent;
import com.example.nbaseasonstats.model.Player;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseInteractorUnitTest {

    private DatabaseInteractor interactor;
    private EventBus eventbus;
    private MockData mocks = new MockData();
    @Mock
    NBAPlayerDao nbaPlayerDao;

    private GetPlayerCallback playersCallback;
    private CreatePlayerCallback createPlayersCallback;
    private UpdatePlayerCallback updatePlayerCallback;


    public abstract class GetPlayerCallback {
        abstract void onSuccess(GetPlayersFromDbEvent event);
    }

    public abstract class CreatePlayerCallback {
        abstract void onSuccess(InsertPlayersToDbEvent event);
    }

    public abstract class UpdatePlayerCallback {
        abstract void onSuccess(UpdatePlayerDbEvent event);
    }

    @Before
    public void setup() {
        eventbus = EventBus.getDefault();
        eventbus.register(this);
        interactor = new DatabaseInteractor(nbaPlayerDao, eventbus);
    }

    @After
    public void setdown() {
        eventbus.unregister(this);
    }

    @Test
    public void  getAllPlayers() {
        playersCallback = new GetPlayerCallback() {
            @Override
            public  void onSuccess(GetPlayersFromDbEvent event){
                Assert.assertNotNull(event);
                Assert.assertEquals(event.getPlayers().size(), mocks.getPlayersFromDbMock().size());
            }
        };

        when(nbaPlayerDao.getAll())
                .thenReturn(mocks.getPlayersFromDbMock());
        interactor.getPlayersFromDb();

        verify(nbaPlayerDao).getAll();

    }

    @Test
    public void  getAllPlayersError() {
        playersCallback = new GetPlayerCallback() {
            @Override
            public  void onSuccess(GetPlayersFromDbEvent event){
                Assert.assertNotNull(event);
                Assert.assertEquals(event.getThrowable().getMessage(), "DB error");
            }
        };

        when(nbaPlayerDao.getAll()).thenAnswer(invocation -> { throw new Exception("DB error"); });
        interactor.getPlayersFromDb();

        verify(nbaPlayerDao).getAll();

    }

    @Test
    public void  insertPlayers() {
        createPlayersCallback = new CreatePlayerCallback() {
            @Override
            public  void onSuccess(InsertPlayersToDbEvent event){
                Assert.assertNotNull(event);
                Assert.assertTrue(event.isDone());
            }
        };

        List<Player> players = mocks.getPlayersFromDbMock();
        interactor.insertPlayersDb(players);

        verify(nbaPlayerDao).insertAll(players);

    }

    @Test
    public void  updatePlayer() {
        updatePlayerCallback = new UpdatePlayerCallback() {
            @Override
            public  void onSuccess(UpdatePlayerDbEvent event){
                Assert.assertNotNull(event);
                Assert.assertTrue(event.isDone());
            }
        };

        Player player = mocks.getPlayerMock(1l);
        interactor.updatePlayerDb(player);

        verify(nbaPlayerDao).update(player);

    }


    @Subscribe
    public void onEventMainThread(GetPlayersFromDbEvent event) {
        playersCallback.onSuccess(event);
    }

    @Subscribe
    public void onEventMainThread(InsertPlayersToDbEvent event) {
        createPlayersCallback.onSuccess(event);
    }

    @Subscribe
    public void onEventMainThread(UpdatePlayerDbEvent event) {
        updatePlayerCallback.onSuccess(event);
    }
}
