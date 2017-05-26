package com.arfirman1402.dev.wikif1.activity.race.view;

import com.arfirman1402.dev.wikif1.activity.race.model.IRaceM;

import rx.Observer;

/**
 * Created by arfirman1402 on 21/05/17.
 */

public interface RaceV extends Observer<IRaceM> {
    @Override
    void onNext(IRaceM result);
}