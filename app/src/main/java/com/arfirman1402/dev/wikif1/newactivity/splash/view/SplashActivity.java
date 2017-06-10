package com.arfirman1402.dev.wikif1.newactivity.splash.view;

import android.os.Bundle;
import android.util.Log;

import com.arfirman1402.dev.wikif1.App;
import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.base.BaseActivity;
import com.arfirman1402.dev.wikif1.newactivity.main.view.MainActivity;
import com.arfirman1402.dev.wikif1.newactivity.splash.model.ISplashM;
import com.arfirman1402.dev.wikif1.newactivity.splash.presenter.ISplashP;
import com.arfirman1402.dev.wikif1.newactivity.splash.presenter.SplashP;
import com.arfirman1402.dev.wikif1.util.model.season.Season;

import java.util.ArrayList;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by alodokter-it on 16/05/17 -- SplashActivity.
 */

public class SplashActivity extends BaseActivity<ISplashM> implements SplashV {
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_splash);

        SplashP presenter = new ISplashP(this);

        setSubscribe(presenter.getResult(), new DisposableObserver<ISplashM>() {
            @Override
            public void onError(Throwable error) {
                Log.d(TAG, "onError: " + error.toString());
            }

            @Override
            public void onNext(final ISplashM result) {
                Log.d(TAG, "onNext: " + App.getInstance().getGson().toJson(result));
                ArrayList<Season> seasons = result.getSeasonList().getSeasonTable().getSeasons();
                openMain(seasons);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onCompleted: Has reached");
            }
        });
    }

    private void openMain(ArrayList<Season> seasons) {
        Bundle bundle = new Bundle();
        bundle.putString("seasons", App.getInstance().getGson().toJson(seasons));
        openNewActivity(MainActivity.class, bundle, true);
    }
}