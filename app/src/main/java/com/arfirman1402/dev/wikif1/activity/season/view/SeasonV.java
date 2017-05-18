package com.arfirman1402.dev.wikif1.activity.season.view;

import com.arfirman1402.dev.wikif1.activity.season.model.ISeasonM;
import com.arfirman1402.dev.wikif1.util.model.race.Race;

import rx.Observer;

/**
 * Created by alodokter-it on 17/05/17 -- SeasonV.
 */

public interface SeasonV extends Observer<ISeasonM> {
    @Override
    void onCompleted();

    @Override
    void onError(Throwable e);

    @Override
    void onNext(ISeasonM result);

    void openRace(Race race);
}
