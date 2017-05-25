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

    @BindView(R.id.race_title)
    TextView raceTitle;

    public VHResult(View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(Result data) {
        Log.d(TAG, "bindData: " + App.getInstance().getGson().toJson(data));
        raceTitle.setText(App.getInstance().getGson().toJson(data));
    }
}
