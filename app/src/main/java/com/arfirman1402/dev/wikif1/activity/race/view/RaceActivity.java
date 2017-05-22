package com.arfirman1402.dev.wikif1.activity.race.view;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.arfirman1402.dev.wikif1.App;
import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.base.BaseActivity;
import com.arfirman1402.dev.wikif1.base.BaseConstant;
import com.arfirman1402.dev.wikif1.util.model.race.Race;

/**
 * Created by arfirman1402 on 21/05/17.
 */

public class RaceActivity extends BaseActivity {
    private Race race;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_race);

        race = App.getInstance().getGson().fromJson(getIntent().getExtras().getString(BaseConstant.RACE_CODE), Race.class);
        Log.d(TAG, "bindData: " + race.getSeason() + " - " + race.getRaceName() + " - " + race.getDate() + " - " + race.getCircuit().getCircuitName() + ", " + race.getCircuit().getLocation().getLocality() + ", " + race.getCircuit().getLocation().getCountry());

        initView();
    }

    private void initView() {
        setTitle(race.getRaceName());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return true;
    }
}
