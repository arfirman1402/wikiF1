package com.arfirman1402.dev.wikif1.activity.race.model;

import com.arfirman1402.dev.wikif1.base.BaseConstant;
import com.arfirman1402.dev.wikif1.base.IBaseM;
import com.arfirman1402.dev.wikif1.util.model.race.RaceList;
import com.google.gson.annotations.SerializedName;

/**
 * Created by arfirman1402 on 21/05/17.
 */

public class IRaceM extends IBaseM implements RaceM {
    @SerializedName(BaseConstant.BASE_DATA)
    private RaceList raceList;

    public RaceList getRaceList() {
        return raceList;
    }
}