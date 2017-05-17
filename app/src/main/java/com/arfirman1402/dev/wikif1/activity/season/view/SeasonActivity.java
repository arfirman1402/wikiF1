package com.arfirman1402.dev.wikif1.activity.season.view;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.base.BaseActivity;

/**
 * Created by alodokter-it on 17/05/17 -- SeasonActivity.
 */

public class SeasonActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_season_detail);
    }
}
