package com.example.nbaseasonstats.database;

import android.content.Context;


import dagger.Module;


@Module
public class DatabaseModule {

    Context context;

    public DatabaseModule(Context context){
        this.context = context;
    }

}
