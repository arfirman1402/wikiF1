package com.arfirman1402.dev.wikif1.main.presenter;

import com.arfirman1402.dev.wikif1.main.model.IMainM;
import com.arfirman1402.dev.wikif1.main.model.MainM;
import com.arfirman1402.dev.wikif1.main.view.MainV;
import com.arfirman1402.dev.wikif1.util.OkHttpTime;
import com.arfirman1402.dev.wikif1.util.RxOkhttp;
import com.google.gson.GsonBuilder;

import okhttp3.Request;
import rx.Observable;

/**
 * Created by alodokter-it on 16/05/17 -- IMainP.
 */

public class IMainP implements MainP {
    private MainM model;
    private MainV view;

    public IMainP(MainV view) {
        model = new IMainM();
        this.view = view;
    }

    @Override
    public Observable<IMainM> getResult() {
        Request request = model.build();
        return RxOkhttp.streamStrings(OkHttpTime.client, request)
                .map(json -> new GsonBuilder().create().fromJson(json, IMainM.class));
    }
}