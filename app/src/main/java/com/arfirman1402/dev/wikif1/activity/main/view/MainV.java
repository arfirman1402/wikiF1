package com.arfirman1402.dev.wikif1.activity.main.view;

import com.arfirman1402.dev.wikif1.activity.main.model.IMainM;
import com.arfirman1402.dev.wikif1.util.model.season.Season;

import rx.Observer;

/**
 * Created by alodokter-it on 16/05/17 -- MainV.
 */

public interface MainV extends Observer<IMainM> {
    @Override
    void onNext(IMainM result);

    void openSeason(Season season);
}