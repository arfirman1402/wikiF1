package com.arfirman1402.dev.wikif1.activity.season.presenter;

import com.arfirman1402.dev.wikif1.App;
import com.arfirman1402.dev.wikif1.activity.season.model.ISeasonM;
import com.arfirman1402.dev.wikif1.activity.season.model.SeasonM;
import com.arfirman1402.dev.wikif1.activity.season.view.SeasonV;
import com.arfirman1402.dev.wikif1.util.model.race.Race;
import com.arfirman1402.dev.wikif1.util.model.season.Season;
import com.arfirman1402.dev.wikif1.util.okhttp.OkHttpTime;
import com.arfirman1402.dev.wikif1.util.okhttp.RxOkhttp;

import okhttp3.Request;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by alodokter-it on 17/05/17 -- ISeasonP.
 */

public class ISeasonP implements SeasonP {
    private SeasonM model;
    private SeasonV view;

    public ISeasonP(SeasonV view) {
        model = new ISeasonM();
        this.view = view;
    }

    @Override
    public Observable<ISeasonM> getResult(Season season) {
        Request request = model.build(season);
        return RxOkhttp.streamStrings(OkHttpTime.client, request)
                .map(new Func1<String, ISeasonM>() {
                    @Override
                    public ISeasonM call(String json) {
                        return App.getInstance().getGson().fromJson(json, ISeasonM.class);
                    }
                });
    }

    @Override
    public void onClickList(Race race) {
        view.openRace(race);
    }
}
