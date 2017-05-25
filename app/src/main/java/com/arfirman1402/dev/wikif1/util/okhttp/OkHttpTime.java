package com.arfirman1402.dev.wikif1.util.okhttp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by alodokter-it on 14/05/17 -- OkHttpTime.
 */

public class OkHttpTime {
    public static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(30000L, TimeUnit.MILLISECONDS)
            .readTimeout(30000L, TimeUnit.MILLISECONDS)
            .build();
}