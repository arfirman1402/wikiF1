package com.arfirman1402.dev.wikif1.main.view;

import com.arfirman1402.dev.wikif1.main.model.IMainM;

/**
 * Created by alodokter-it on 16/05/17 -- MainV.
 */

public interface MainV {
    void onSuccess(IMainM result);

    void onError(Throwable error);

    void onCompleted();
}
