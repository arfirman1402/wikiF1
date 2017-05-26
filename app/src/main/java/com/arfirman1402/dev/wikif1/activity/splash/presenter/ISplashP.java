package com.arfirman1402.dev.wikif1.activity.splash.presenter;

import android.os.Handler;

import com.arfirman1402.dev.wikif1.activity.splash.view.SplashV;

/**
 * Created by alodokter-it on 16/05/17 -- ISplashP.
 */

public class ISplashP implements SplashP {
    private SplashV view;

    public ISplashP(SplashV view) {
        this.view = view;
    }

    @Override
    public void startTimer(int duration) {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                view.openMain();
            }
        };
        handler.postDelayed(runnable, duration);
    }
}