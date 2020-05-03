package com.example.nbaseasonstats.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.nbaseasonstats.model.Player;


@Database(entities = {Player.class}, version = 1)
public abstract class NBAPlayerDatabase extends RoomDatabase {
    public abstract NBAPlayerDao playerDao();
}
