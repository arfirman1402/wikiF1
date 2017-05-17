package com.arfirman1402.dev.wikif1.main.view.holder;

import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.base.BaseHolder;
import com.arfirman1402.dev.wikif1.util.model.Season;

import butterknife.BindView;

/**
 * Created by alodokter-it on 17/05/17 -- VHSeason.
 */

public class VHSeason extends BaseHolder {
    private final String TAG = this.getClass().getSimpleName();

    @BindView(R.id.season_year)
    TextView seasonYear;

    @BindView(R.id.season_card_view)
    CardView seasonCardView;

    public VHSeason(View itemView) {
        super(itemView);
    }

    public void bindData(final Season season) {
        seasonYear.setText(season.getSeason());
        Log.d(TAG, "bindData: " + season.getSeason() + " - " + season.getUrl());
        seasonCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), season.getSeason() + " - " + season.getUrl(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}