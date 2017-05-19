package com.arfirman1402.dev.wikif1.activity.season.view.holder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.base.BaseHolder;
import com.arfirman1402.dev.wikif1.util.model.race.Race;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;

/**
 * Created by alodokter-it on 18/05/17 -- VHRace.
 */

public class VHRace extends BaseHolder<Race> {
    @BindView(R.id.race_round)
    TextView raceRound;

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

    @Override
    public void bindData(Race data) {
        raceRound.setText(data.getRound());
        raceTitle.setText(data.getRaceName());
        raceDate.setText(data.getDate());
        raceLocation.setText(data.getCircuit().getCircuitName() + ", " + data.getCircuit().getLocation().getLocality() + ", " + data.getCircuit().getLocation().getCountry());
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(data.getDate());
            String result = new SimpleDateFormat("EEE, dd MMMM yyyy", Locale.getDefault()).format(date);
            raceDate.setText(result);
        } catch (ParseException e) {
            e.printStackTrace();
            Log.d(TAG, "bindData: " + e.toString());
        }
        Log.d(TAG, "bindData: " + data.getSeason() + " - " + data.getRaceName() + " - " + data.getDate() + " - " + data.getCircuit().getCircuitName() + ", " + data.getCircuit().getLocation().getLocality() + ", " + data.getCircuit().getLocation().getCountry());
    }
}
