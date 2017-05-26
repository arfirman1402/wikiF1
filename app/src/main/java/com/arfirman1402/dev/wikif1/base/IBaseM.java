package com.arfirman1402.dev.wikif1.base;

import com.arfirman1402.dev.wikif1.util.retrofit.ApiService;
import com.arfirman1402.dev.wikif1.util.retrofit.ServiceFactory;

/**
 * Created by alodokter-it on 26/05/17 -- IBaseM.
 */

public class IBaseM implements BaseM {
    @Override
    public ApiService build() {
        return ServiceFactory.createRetrofitService(ApiService.class, ApiService.API_URL);
    }
}