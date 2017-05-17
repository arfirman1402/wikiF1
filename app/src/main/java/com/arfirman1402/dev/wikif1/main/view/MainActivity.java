package com.arfirman1402.dev.wikif1.main.view;

import android.os.Bundle;
import android.util.Log;

import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.base.BaseActivity;
import com.arfirman1402.dev.wikif1.main.model.IMainM;
import com.arfirman1402.dev.wikif1.main.presenter.IMainP;
import com.arfirman1402.dev.wikif1.main.presenter.MainP;
import com.google.gson.GsonBuilder;

public class MainActivity extends BaseActivity<IMainM> implements MainV {
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_main);

        MainP presenter = new IMainP(this);

        setSubscribe(presenter.getResult(), this);
    }

    @Override
    public void onError(Throwable error) {
        Log.d(TAG, "onError: " + error.toString());
    }

    @Override
    public void onNext(IMainM result) {
        Log.d(TAG, "onSuccess: " + new GsonBuilder().create().toJson(result.getMrData().getSeasonTable().getSeasons()));
    }

    @Override
    public void onCompleted() {
        Log.d(TAG, "onCompleted: Has reached");
    }
}