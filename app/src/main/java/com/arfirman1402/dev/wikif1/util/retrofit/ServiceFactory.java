package com.arfirman1402.dev.wikif1.util.retrofit;

import retrofit.RestAdapter;

public class ServiceFactory {
    public static <T> T createRetrofitService(final Class<T> clazz, final String endPoint) {
        final RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(endPoint)
                .build();
        return restAdapter.create(clazz);
    }
}