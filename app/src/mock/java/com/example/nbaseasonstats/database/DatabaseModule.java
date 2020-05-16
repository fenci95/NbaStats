package com.example.nbaseasonstats.database;

import android.content.Context;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DatabaseModule {

    Context context;

    public DatabaseModule(Context context){
        this.context = context;
    }


}
