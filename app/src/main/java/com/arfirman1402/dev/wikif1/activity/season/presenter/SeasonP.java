package com.arfirman1402.dev.wikif1.activity.season.presenter;

import com.arfirman1402.dev.wikif1.activity.season.model.ISeasonM;
import com.arfirman1402.dev.wikif1.util.model.race.Race;
import com.arfirman1402.dev.wikif1.util.model.season.Season;

import rx.Observable;

/**
 * Created by alodokter-it on 17/05/17 -- SeasonP.
 */

public interface SeasonP {
    Observable<ISeasonM> getResult(Season season);

    void onClickList(Race race);
}
