package com.arfirman1402.dev.wikif1.activity.main.model;

import com.arfirman1402.dev.wikif1.util.model.season.SeasonList;
import com.arfirman1402.dev.wikif1.util.retrofit.ApiService;
import com.arfirman1402.dev.wikif1.util.retrofit.ServiceFactory;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alodokter-it on 16/05/17 -- IMainM.
 */

public class IMainM implements MainM {
    @SerializedName("MRData")
    private SeasonList seasonList;
    private String TAG = getClass().getSimpleName();

    public SeasonList getSeasonList() {
        return seasonList;
    }

    @Override
    public ApiService build() {
        return ServiceFactory.createRetrofitService(ApiService.class, ApiService.API_URL);
    }
}