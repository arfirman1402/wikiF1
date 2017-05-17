package com.arfirman1402.dev.wikif1.main.view;

import com.arfirman1402.dev.wikif1.main.model.IMainM;

import rx.Observer;

/**
 * Created by alodokter-it on 16/05/17 -- MainV.
 */

public interface MainV extends Observer<IMainM> {
    @Override
    void onCompleted();

    @Override
    void onError(Throwable e);

    @Override
    void onNext(IMainM result);
}
