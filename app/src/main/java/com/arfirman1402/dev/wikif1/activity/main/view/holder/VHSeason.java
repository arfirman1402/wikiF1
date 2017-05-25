package com.arfirman1402.dev.wikif1.activity.main.view.holder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.base.BaseHolder;
import com.arfirman1402.dev.wikif1.util.model.season.Season;

import butterknife.BindView;

/**
 * Created by alodokter-it on 17/05/17 -- VHSeason.
 */

public class VHSeason extends BaseHolder<Season> {
    private final String TAG = this.getClass().getSimpleName();

    @BindView(R.id.season_year)
    TextView seasonYear;

    public VHSeason(View itemView) {
        super(itemView);
    }

    public void bindData(Season data) {
        seasonYear.setText(data.getSeason());
        Log.d(TAG, "bindData: " + data.getSeason() + " - " + data.getUrl());
    }
}