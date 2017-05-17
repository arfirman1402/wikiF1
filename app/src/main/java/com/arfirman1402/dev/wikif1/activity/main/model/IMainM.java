package com.arfirman1402.dev.wikif1.activity.main.model;

import android.util.Log;

import com.arfirman1402.dev.wikif1.base.BaseUrl;
import com.arfirman1402.dev.wikif1.util.model.MRData;
import com.google.gson.annotations.SerializedName;

import okhttp3.Request;

/**
 * Created by alodokter-it on 16/05/17 -- IMainM.
 */

public class IMainM implements MainM {
    @SerializedName("MRData")
    private MRData mrData;
    private String TAG = getClass().getSimpleName();

    public MRData getMrData() {
        return mrData;
    }

    @Override
    public Request build() {
        Log.d(TAG, "build: " + BaseUrl.getSeasonList());
        return new Request.Builder().get().url(BaseUrl.getSeasonList()).build();
    }
}
