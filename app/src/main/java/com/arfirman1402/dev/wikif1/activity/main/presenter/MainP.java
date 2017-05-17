package com.arfirman1402.dev.wikif1.activity.main.presenter;

import com.arfirman1402.dev.wikif1.activity.main.model.IMainM;
import com.arfirman1402.dev.wikif1.util.model.season.Season;

import rx.Observable;

/**
 * Created by alodokter-it on 16/05/17 -- MainP.
 */

public interface MainP {
    Observable<IMainM> getResult();

    void onClickList(Season season);
}
