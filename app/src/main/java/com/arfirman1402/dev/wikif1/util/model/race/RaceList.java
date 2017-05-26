package com.arfirman1402.dev.wikif1.util.model.race;

import com.arfirman1402.dev.wikif1.base.BaseModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alodokter-it on 17/05/17 -- SeasonList.
 */

public class RaceList extends BaseModel {
    @SerializedName("RaceTable")
    private RaceTable raceTable;

    public RaceTable getRaceTable() {
        return raceTable;
    }
}