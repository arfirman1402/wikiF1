package com.arfirman1402.dev.wikif1.newactivity.main.presenter;

import com.arfirman1402.dev.wikif1.newactivity.main.model.IMainM;
import com.arfirman1402.dev.wikif1.util.model.season.Season;

import io.reactivex.Observable;

/**
 * Created by alodokter-it on 16/05/17 -- MainP.
 */

public interface MainP {
    Observable<IMainM> getResult();

    void onClickList(Season season);
}