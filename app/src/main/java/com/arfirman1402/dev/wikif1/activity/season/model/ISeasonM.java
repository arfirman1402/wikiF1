package com.arfirman1402.dev.wikif1.activity.season.model;

import android.util.Log;

import com.arfirman1402.dev.wikif1.base.BaseUrl;
import com.arfirman1402.dev.wikif1.util.model.race.RaceList;
import com.arfirman1402.dev.wikif1.util.model.season.Season;
import com.google.gson.annotations.SerializedName;

import okhttp3.Request;

/**
 * Created by alodokter-it on 17/05/17 -- ISeasonM.
 */

public class ISeasonM implements SeasonM {
    @SerializedName("MRData")
    private RaceList raceList;
    private String TAG = getClass().getSimpleName();

    public RaceList getRaceList() {
        return raceList;
    }

    @Override
    public Request build(Season season) {
        Log.d(TAG, "build: " + BaseUrl.getSeasonDetail(season));
        return new Request.Builder().get().url(BaseUrl.getSeasonDetail(season)).build();
    }
}