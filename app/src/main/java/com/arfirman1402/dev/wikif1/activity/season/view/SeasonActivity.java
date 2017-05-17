package com.arfirman1402.dev.wikif1.activity.season.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.arfirman1402.dev.wikif1.App;
import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.activity.season.model.ISeasonM;
import com.arfirman1402.dev.wikif1.activity.season.presenter.ISeasonP;
import com.arfirman1402.dev.wikif1.activity.season.presenter.SeasonP;
import com.arfirman1402.dev.wikif1.base.BaseActivity;
import com.arfirman1402.dev.wikif1.base.BaseConstant;
import com.arfirman1402.dev.wikif1.util.model.race.Race;
import com.arfirman1402.dev.wikif1.util.model.season.Season;

/**
 * Created by alodokter-it on 17/05/17 -- SeasonActivity.
 */

public class SeasonActivity extends BaseActivity<ISeasonM> implements SeasonV {
    private String TAG = this.getClass().getSimpleName();
    private SeasonP presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_season_detail);

        Season season = App.getInstance().getGson().fromJson(getIntent().getExtras().getString(BaseConstant.SEASON_CODE), Season.class);

        Log.d(TAG, "onCreate: " + season.getSeason() + " - " + season.getUrl());

        presenter = new ISeasonP(this);

        setSubscribe(presenter.getResult(season), this);
    }

    @Override
    public void onCompleted() {
        Log.d(TAG, "onCompleted: has Reached");
    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: " + e.toString());
    }

    @Override
    public void onNext(ISeasonM result) {
        Log.d(TAG, "onNext: " + App.getInstance().getGson().toJson(result));
        for (Race race : result.getRaceList().getRaceTable().getRaces()) {
            Log.d(TAG, "onNext: " + race.getSeason() + " - " + race.getDate() + " - " + race.getRaceName());
        }
    }
}
