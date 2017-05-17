package com.arfirman1402.dev.wikif1.activity.season.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.arfirman1402.dev.wikif1.App;
import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.base.BaseActivity;
import com.arfirman1402.dev.wikif1.base.BaseConstant;
import com.arfirman1402.dev.wikif1.util.model.Season;

/**
 * Created by alodokter-it on 17/05/17 -- SeasonActivity.
 */

public class SeasonActivity extends BaseActivity {
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_season_detail);

        Season season = App.getInstance().getGson().fromJson(getIntent().getExtras().getString(BaseConstant.SEASON_CODE), Season.class);

        Log.d(TAG, "onCreate: " + season.getSeason() + " - " + season.getUrl());
    }
}
