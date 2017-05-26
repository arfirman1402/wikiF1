package com.arfirman1402.dev.wikif1.activity.race.presenter;

import com.arfirman1402.dev.wikif1.activity.race.model.IRaceM;
import com.arfirman1402.dev.wikif1.util.model.race.Race;

import rx.Observable;

/**
 * Created by arfirman1402 on 21/05/17.
 */

public interface RaceP {
    Observable<IRaceM> getResult(Race race);
}