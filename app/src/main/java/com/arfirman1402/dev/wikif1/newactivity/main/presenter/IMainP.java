package com.arfirman1402.dev.wikif1.newactivity.main.presenter;

import com.arfirman1402.dev.wikif1.newactivity.main.model.IMainM;
import com.arfirman1402.dev.wikif1.newactivity.main.model.MainM;
import com.arfirman1402.dev.wikif1.newactivity.main.view.MainV;
import com.arfirman1402.dev.wikif1.util.model.season.Season;
import com.arfirman1402.dev.wikif1.util.retrofit.ApiService;

import io.reactivex.Observable;

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
    public Observable<IMainM> getResult(Season season) {
        ApiService service = model.build();
        return service.getSeasonDetail(season.getSeason(), ApiService.DATA_LIMIT);
    }

    @Override
    public void onClickList(Season season) {
        view.getData(season);
    }
}