package com.arfirman1402.dev.wikif1.activity.race.model;

import com.arfirman1402.dev.wikif1.util.model.race.RaceList;
import com.arfirman1402.dev.wikif1.util.retrofit.ApiService;
import com.arfirman1402.dev.wikif1.util.retrofit.ServiceFactory;
import com.google.gson.annotations.SerializedName;

/**
 * Created by arfirman1402 on 21/05/17.
 */

public class IRaceM implements RaceM {
    @SerializedName("MRData")
    private RaceList raceList;
    private String TAG = getClass().getSimpleName();

    public RaceList getRaceList() {
        return raceList;
    }

    @Override
    public ApiService build() {
        return ServiceFactory.createRetrofitService(ApiService.class, ApiService.API_URL);
    }
}
