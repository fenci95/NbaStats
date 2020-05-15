package com.example.nbaseasonstats.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nbaseasonstats.R;
import com.example.nbaseasonstats.model.Player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PlayerListAdapter extends RecyclerView.Adapter<PlayerListAdapter.PlayerListViewHolder> {

    private List<Player> playerList;
    private PlayerClickListener listener;
    Context context;

    public PlayerListAdapter(
            PlayerClickListener listener,
            Context context
    ) {
        this.playerList = new ArrayList<Player>();
        this.listener = listener;
        this.context = context;
    }

    @Override
    public PlayerListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.player_list_item, parent, false);
        return new PlayerListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerListViewHolder holder, int position) {
        Player player = playerList.get(position);
        holder.player = player;
        String name = player.firstName + ' ' + player.lastName;
        holder.tvName.setText(name);
        if (player.isFavourite) {
            holder.ibFavorite.setImageResource(R.drawable.star_filled);
        } else {
            holder.ibFavorite.setImageResource(R.drawable.star_empty);
        }
    }

    public void update(List<Player> players) {
        playerList.clear();
        playerList.addAll(players);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    class PlayerListViewHolder extends RecyclerView.ViewHolder {
        public TextView tvName;
        public ImageButton ibFavorite;
        public Player player;

        PlayerListViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.PlayerItemNameTextView);
            ibFavorite = itemView.findViewById(R.id.PlayerItemFavoriteButton);

            itemView.setOnClickListener(v -> listener.onPlayerItemClicked(player));

            ibFavorite.setOnClickListener(v -> listener.onFavoriteButtonClicked(player));
        }
    }

    public interface PlayerClickListener{
        void onPlayerItemClicked(Player player);
        void onFavoriteButtonClicked(Player player);
    }

}
