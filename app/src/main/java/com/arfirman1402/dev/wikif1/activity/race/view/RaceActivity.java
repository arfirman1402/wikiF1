package com.arfirman1402.dev.wikif1.activity.race.view;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.arfirman1402.dev.wikif1.App;
import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.activity.race.model.IRaceM;
import com.arfirman1402.dev.wikif1.activity.race.presenter.IRaceP;
import com.arfirman1402.dev.wikif1.activity.race.presenter.RaceP;
import com.arfirman1402.dev.wikif1.base.BaseActivity;
import com.arfirman1402.dev.wikif1.base.BaseConstant;
import com.arfirman1402.dev.wikif1.util.model.race.Race;
import com.arfirman1402.dev.wikif1.util.model.race.Result;

/**
 * Created by arfirman1402 on 21/05/17.
 */

public class RaceActivity extends BaseActivity<IRaceM> implements RaceV {
    private Race race;
    private String TAG = this.getClass().getSimpleName();
    private RaceP presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_race);

        race = App.getInstance().getGson().fromJson(getIntent().getExtras().getString(BaseConstant.RACE_CODE), Race.class);
        Log.d(TAG, "bindData: " + race.getSeason() + " - " + race.getRaceName() + " - " + race.getDate() + " - " + race.getCircuit().getCircuitName() + ", " + race.getCircuit().getLocation().getLocality() + ", " + race.getCircuit().getLocation().getCountry());

        initView();

        presenter = new IRaceP(this);

        setSubscribe(presenter.getResult(race), this);
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

    @Override
    public void onCompleted() {
        Log.d(TAG, "onCompleted: has reached");
    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: " + e.toString());
    }

    @Override
    public void onNext(IRaceM result) {
        Log.d(TAG, "onNext: has Reached");
        for (Result raceResult : result.getRaceList().getRaceTable().getRaces().get(0).getResults()) {
            Log.d(TAG, "onNext: Data = " + App.getInstance().getGson().toJson(raceResult));
        }
    }
}
