package com.arfirman1402.dev.wikif1;

import android.app.Application;

import com.arfirman1402.dev.wikif1.util.retrofit.ApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alodokter-it on 17/05/17 -- App.
 */

public class App extends Application {
    private static App instance;
    private Gson gson;
    private Retrofit retrofit;

    public App() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        createGson();

        createRetrofitClient();
    }

    private void createGson() {
        if (gson == null) {
            gson = new GsonBuilder().create();
        }
    }

    private void createRetrofitClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public Gson getGson() {
        return gson;
    }

    public Retrofit getRetrofitClient() {
        return retrofit;
    }
}