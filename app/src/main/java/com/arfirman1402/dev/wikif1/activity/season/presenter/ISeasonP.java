package com.arfirman1402.dev.wikif1.activity.season.presenter;

import com.arfirman1402.dev.wikif1.activity.season.model.ISeasonM;
import com.arfirman1402.dev.wikif1.activity.season.model.SeasonM;
import com.arfirman1402.dev.wikif1.activity.season.view.SeasonV;
import com.arfirman1402.dev.wikif1.util.model.race.Race;
import com.arfirman1402.dev.wikif1.util.model.season.Season;
import com.arfirman1402.dev.wikif1.util.retrofit.ApiService;

import io.reactivex.Observable;

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
        ApiService service = model.build();
        return service.getSeasonDetail(season.getSeason(), ApiService.DATA_LIMIT);
    }

    @Override
    public void onClickList(Race race) {
        view.openRace(race);
    }
}