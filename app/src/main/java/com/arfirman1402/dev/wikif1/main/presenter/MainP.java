package com.arfirman1402.dev.wikif1.main.presenter;

import com.arfirman1402.dev.wikif1.main.model.IMainM;

import rx.Observable;

/**
 * Created by alodokter-it on 16/05/17 -- MainP.
 */

public interface MainP {
    Observable<IMainM> getResult();
}
