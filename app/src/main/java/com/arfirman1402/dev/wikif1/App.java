package com.arfirman1402.dev.wikif1;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by alodokter-it on 17/05/17 -- App.
 */

public class App extends Application {
    private static App instance;
    private Gson gson;

    public App() {
        instance = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        createGson();
    }

    private void createGson() {
        if (gson == null) {
            gson = new GsonBuilder().create();
        }
    }

    public static App getInstance() {
        return instance;
    }

    public Gson getGson() {
        return gson;
    }
}