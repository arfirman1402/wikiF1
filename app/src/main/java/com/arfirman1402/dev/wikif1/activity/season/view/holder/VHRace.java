package com.arfirman1402.dev.wikif1.activity.season.view.holder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.base.BaseHolder;
import com.arfirman1402.dev.wikif1.util.model.race.Race;

import butterknife.BindView;

/**
 * Created by alodokter-it on 18/05/17 -- VHRace.
 */

public class VHRace extends BaseHolder {
    @BindView(R.id.race_season)
    TextView raceSeason;

    @BindView(R.id.race_title)
    TextView raceTitle;

    @BindView(R.id.race_date)
    TextView raceDate;

    @BindView(R.id.race_location)
    TextView raceLocation;

    private String TAG = this.getClass().getSimpleName();

    public VHRace(View itemView) {
        super(itemView);
    }

    public void bindData(Race race) {
        raceSeason.setText(race.getSeason());
        raceTitle.setText(race.getRaceName());
        raceDate.setText(race.getDate());
        raceLocation.setText(race.getCircuit().getCircuitName() + ", " + race.getCircuit().getLocation().getLocality() + ", " + race.getCircuit().getLocation().getCountry());
        Log.d(TAG, "bindData: " + race.getSeason() + " - " + race.getRaceName() + " - " + race.getDate() + " - " + race.getCircuit().getCircuitName() + ", " + race.getCircuit().getLocation().getLocality() + ", " + race.getCircuit().getLocation().getCountry());
    }
}
