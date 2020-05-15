package com.example.nbaseasonstats.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "players")
public class Player {
    @PrimaryKey
    public Long id;

    public String firstName;

    public String lastName;

    public boolean isFavourite;
}
