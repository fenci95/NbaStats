package com.example.nbaseasonstats.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.nbaseasonstats.model.Player;

import java.util.List;

@Dao
public interface NBAPlayerDao {
    @Query("SELECT * FROM players")
    List<Player> getAll();

    @Insert
    void insertAll(List<Player> players);

    @Update(onConflict = OnConflictStrategy.IGNORE)
    void update(Player player);
}
