package com.arfirman1402.dev.wikif1.activity.race.presenter;

import com.arfirman1402.dev.wikif1.activity.race.model.IRaceM;
import com.arfirman1402.dev.wikif1.activity.race.model.RaceM;
import com.arfirman1402.dev.wikif1.activity.race.view.RaceV;
import com.arfirman1402.dev.wikif1.util.model.race.Race;
import com.arfirman1402.dev.wikif1.util.retrofit.ApiService;

import io.reactivex.Observable;

/**
 * Created by arfirman1402 on 21/05/17.
 */

public class IRaceP implements RaceP {
    RaceM model;
    RaceV view;

    public IRaceP(RaceV view) {
        model = new IRaceM();
        this.view = view;
    }

    @Override
    public Observable<IRaceM> getResult(Race race) {
        ApiService service = model.build();
        return service.getRaceResult(race.getSeason(), race.getRound(), ApiService.DATA_LIMIT);
    }
}