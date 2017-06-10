package com.arfirman1402.dev.wikif1.newactivity.splash.presenter;

import com.arfirman1402.dev.wikif1.newactivity.splash.model.ISplashM;

import io.reactivex.Observable;

/**
 * Created by alodokter-it on 16/05/17 -- SplashP.
 */

public interface SplashP {
    Observable<ISplashM> getResult();
}