package com.arfirman1402.dev.wikif1.base;

/**
 * Created by alodokter-it on 16/05/17 -- BaseUrl.
 */

public class BaseUrl {
    private static final String API_URL = "http://ergast.com/api/";
    private static final String F1_SERIES = "f1";
    private static final String SEASONS = "/seasons";
    private static final String RESULT_JSON = ".json";
    private static final String UNLIMITED_DATA = "limit=20";

    public static String getSeasonList() {
        return API_URL + F1_SERIES + SEASONS + RESULT_JSON + "?" + UNLIMITED_DATA;
    }
}
