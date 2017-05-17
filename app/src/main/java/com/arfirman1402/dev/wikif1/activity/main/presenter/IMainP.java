package com.arfirman1402.dev.wikif1.activity.main.presenter;

import com.arfirman1402.dev.wikif1.App;
import com.arfirman1402.dev.wikif1.activity.main.model.IMainM;
import com.arfirman1402.dev.wikif1.activity.main.model.MainM;
import com.arfirman1402.dev.wikif1.activity.main.view.MainV;
import com.arfirman1402.dev.wikif1.util.model.Season;
import com.arfirman1402.dev.wikif1.util.okhttp.OkHttpTime;
import com.arfirman1402.dev.wikif1.util.okhttp.RxOkhttp;

import okhttp3.Request;
import rx.Observable;
import rx.functions.Func1;

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
                .map(new Func1<String, IMainM>() {
                    @Override
                    public IMainM call(String json) {
                        return App.getInstance().getGson().fromJson(json, IMainM.class);
                    }
                });
    }

    @Override
    public void onClickList(Season season) {
        view.openSeason(season);
    }
}