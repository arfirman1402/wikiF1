package com.arfirman1402.dev.wikif1.newactivity.season.model;

import com.arfirman1402.dev.wikif1.base.BaseConstant;
import com.arfirman1402.dev.wikif1.base.IBaseM;
import com.arfirman1402.dev.wikif1.util.model.race.RaceList;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alodokter-it on 17/05/17 -- ISeasonM.
 */

public class ISeasonM extends IBaseM implements SeasonM {
    @SerializedName(BaseConstant.BASE_DATA)
    private RaceList raceList;

    public RaceList getRaceList() {
        return raceList;
    }
}