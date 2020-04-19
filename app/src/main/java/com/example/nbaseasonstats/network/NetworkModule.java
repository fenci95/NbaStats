package com.example.nbaseasonstats.network;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;

@Module
public class NetworkModule {


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().client(client).baseUrl("https://www.balldontlie.io/api/v1/")
                .addConverterFactory(GsonConverterFactory.create()).build();
    }

    @Provides
    @Singleton
    public PlayersAPI providePlayersApi(Retrofit retrofit) {
        return retrofit.create(PlayersAPI.class);
    }

}
