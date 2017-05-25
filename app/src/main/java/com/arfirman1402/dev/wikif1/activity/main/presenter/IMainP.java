package com.arfirman1402.dev.wikif1.activity.main.presenter;

import com.arfirman1402.dev.wikif1.activity.main.model.IMainM;
import com.arfirman1402.dev.wikif1.activity.main.model.MainM;
import com.arfirman1402.dev.wikif1.activity.main.view.MainV;
import com.arfirman1402.dev.wikif1.util.model.season.Season;
import com.arfirman1402.dev.wikif1.util.retrofit.ApiService;

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
        ApiService service = model.build();
        return service.getSeasonList(ApiService.DATA_LIMIT);
    }

    @Override
    public void onClickList(Season season) {
        view.openSeason(season);
    }
}