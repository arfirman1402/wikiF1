package com.arfirman1402.dev.wikif1.activity.race.view.holder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.arfirman1402.dev.wikif1.App;
import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.base.BaseHolder;
import com.arfirman1402.dev.wikif1.util.model.race.Result;

import butterknife.BindView;

/**
 * Created by alodokter-it on 18/05/17 -- VHRace.
 */

public class VHResult extends BaseHolder<Result> {
    private String TAG = this.getClass().getSimpleName();

    @BindView(R.id.race_position)
    TextView racePosition;

    @BindView(R.id.race_driver_name)
    TextView raceDriverName;

    @BindView(R.id.race_constructor_name)
    TextView raceConstructorName;

    @BindView(R.id.race_time)
    TextView raceTime;

    public VHResult(View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(Result data) {
        Log.d(TAG, "bindData: " + App.getInstance().getGson().toJson(data));
        racePosition.setText("P" + data.getPosition());
        raceDriverName.setText("#" + data.getNumber() + " " + data.getDriver().getGivenName() + " " + data.getDriver().getFamilyName());
        raceConstructorName.setText("Team : " + data.getConstructor().getName());
        if (data.getTime() != null) raceTime.setText(data.getTime().getTime());
        else raceTime.setText(data.getStatus());
    }
}