package com.arfirman1402.dev.wikif1.newactivity.main.model;

import com.arfirman1402.dev.wikif1.base.BaseConstant;
import com.arfirman1402.dev.wikif1.base.IBaseM;
import com.arfirman1402.dev.wikif1.util.model.race.RaceList;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alodokter-it on 16/05/17 -- IMainM.
 */

public class IMainM extends IBaseM implements MainM {
    @SerializedName(BaseConstant.BASE_DATA)
    private RaceList raceList;

    public RaceList getRaceList() {
        return raceList;
    }
}