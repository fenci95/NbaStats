package com.example.nbaseasonstats.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.nbaseasonstats.NBAStatsApplication;
import com.example.nbaseasonstats.R;
import com.example.nbaseasonstats.model.Player;
import com.example.nbaseasonstats.model.PlayerListResponse;
import com.example.nbaseasonstats.presenter.PlayerListPresenter;

import java.util.List;

import javax.inject.Inject;

public class PlayerListActivity extends AppCompatActivity implements PlayerListScreen, PlayerListAdapter.PlayerClickListener {

    private RecyclerView recyclerView;
    private PlayerListAdapter adapter;

    @Inject
    PlayerListPresenter playerListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NBAStatsApplication.injector.inject(this);
        initRecyclerView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.playerListPresenter.attachScreen(this);
        this.playerListPresenter.getPlayersFromDb();
        this.setTitle("Players");
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.playerListPresenter.detachScreen();
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.player_list);
        adapter = new PlayerListAdapter(this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showPlayers(List<Player> players) {
        adapter.update(players);
    }

    @Override
    public void showError(Throwable throwable) {
        Log.d("Error", throwable.getMessage());
    }

    @Override
    public void onPlayerItemClicked(Player player) {
        Intent i = new Intent(this, PlayerDetailsActivity.class);
        String name = player.firstName + ' ' + player.lastName;
        i.putExtra("NAME", name);
        i.putExtra("ID", player.id);

        startActivity(i);
    }

    @Override
    public void onFavoriteButtonClicked(Player player) {
        player.isFavourite = !player.isFavourite;
        playerListPresenter.updatePlayerDb(player);
    }
}
