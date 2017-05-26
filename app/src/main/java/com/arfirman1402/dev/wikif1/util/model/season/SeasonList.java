package com.arfirman1402.dev.wikif1.util.model.season;

import com.arfirman1402.dev.wikif1.base.BaseModel;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alodokter-it on 17/05/17 -- SeasonList.
 */

public class SeasonList extends BaseModel {
    @SerializedName("SeasonTable")
    private SeasonTable seasonTable;

    public SeasonTable getSeasonTable() {
        return seasonTable;
    }
}