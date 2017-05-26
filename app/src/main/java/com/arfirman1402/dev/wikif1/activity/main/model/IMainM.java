package com.arfirman1402.dev.wikif1.activity.main.model;

import com.arfirman1402.dev.wikif1.base.IBaseM;
import com.arfirman1402.dev.wikif1.util.model.season.SeasonList;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alodokter-it on 16/05/17 -- IMainM.
 */

public class IMainM extends IBaseM implements MainM {
    @SerializedName("MRData")
    private SeasonList seasonList;
    private String TAG = getClass().getSimpleName();

    public SeasonList getSeasonList() {
        return seasonList;
    }
}