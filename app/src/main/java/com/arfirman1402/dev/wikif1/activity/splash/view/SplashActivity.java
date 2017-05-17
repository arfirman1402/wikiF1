package com.arfirman1402.dev.wikif1.activity.splash.view;

import android.os.Bundle;

import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.base.BaseActivity;
import com.arfirman1402.dev.wikif1.base.BaseConstant;
import com.arfirman1402.dev.wikif1.activity.main.view.MainActivity;
import com.arfirman1402.dev.wikif1.activity.splash.presenter.ISplashP;
import com.arfirman1402.dev.wikif1.activity.splash.presenter.SplashP;

/**
 * Created by alodokter-it on 16/05/17 -- SplashActivity.
 */

public class SplashActivity extends BaseActivity implements SplashV {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_splash);

        SplashP presenter = new ISplashP(this);
        presenter.startTimer(BaseConstant.SPLASH_TIME);
    }

    @Override
    public void openMain() {
        openNewActivity(MainActivity.class, true);
    }
}