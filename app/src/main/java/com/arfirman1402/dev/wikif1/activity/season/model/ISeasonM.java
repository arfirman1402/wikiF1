package com.arfirman1402.dev.wikif1.activity.season.model;

import com.arfirman1402.dev.wikif1.base.IBaseM;
import com.arfirman1402.dev.wikif1.util.model.race.RaceList;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alodokter-it on 17/05/17 -- ISeasonM.
 */

public class ISeasonM extends IBaseM implements SeasonM {
    @SerializedName("MRData")
    private RaceList raceList;
    private String TAG = getClass().getSimpleName();

    public RaceList getRaceList() {
        return raceList;
    }
}