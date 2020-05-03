package com.example.nbaseasonstats.database;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

@Module
public class DatabaseModule {

    Context context;

    DatabaseModule(Context context){
        this.context = context;
    }
    @Provides
    @Singleton
    public NBAPlayerDatabase provideDatabase() {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                NBAPlayerDatabase.class,
                "players"
        ).build();
    }

    @Provides
    @Singleton
    public NBAPlayerDao provideDao(NBAPlayerDatabase db) {
        return db.playerDao();
    }
}
