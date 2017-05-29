package com.arfirman1402.dev.wikif1.base;

import com.arfirman1402.dev.wikif1.App;
import com.arfirman1402.dev.wikif1.util.retrofit.ApiService;

/**
 * Created by alodokter-it on 26/05/17 -- IBaseM.
 */

public class IBaseM implements BaseM {
    @Override
    public ApiService build() {
        return App.getInstance().getRetrofitClient().create(ApiService.class);
    }
}