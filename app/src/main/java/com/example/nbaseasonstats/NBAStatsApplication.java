package com.example.nbaseasonstats;

import android.app.Application;

import com.example.nbaseasonstats.database.DatabaseModule;
import com.example.nbaseasonstats.view.UIModule;

public class NBAStatsApplication extends Application {

    public static NBAStatsApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerNBAStatsApplicationComponent.builder().
                uIModule(
                        new UIModule(this)
                ).databaseModule(
                        new DatabaseModule(this)
                ).build();
    }
}
