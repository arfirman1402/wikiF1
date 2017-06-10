package com.arfirman1402.dev.wikif1.newactivity.splash.presenter;

import com.arfirman1402.dev.wikif1.newactivity.splash.model.ISplashM;
import com.arfirman1402.dev.wikif1.newactivity.splash.model.SplashM;
import com.arfirman1402.dev.wikif1.newactivity.splash.view.SplashV;
import com.arfirman1402.dev.wikif1.util.retrofit.ApiService;

import io.reactivex.Observable;

/**
 * Created by alodokter-it on 16/05/17 -- ISplashP.
 */

public class ISplashP implements SplashP {
    private final SplashM model;
    private SplashV view;

    public ISplashP(SplashV view) {
        this.view = view;
        model = new ISplashM();
    }

    @Override
    public Observable<ISplashM> getResult() {
        ApiService service = model.build();
        return service.getSplashSeasonList(ApiService.DATA_LIMIT);
    }
}