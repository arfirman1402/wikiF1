package com.arfirman1402.dev.wikif1.base;

import com.arfirman1402.dev.wikif1.util.model.season.Season;

/**
 * Created by alodokter-it on 16/05/17 -- BaseUrl.
 */

public class BaseUrl {
    private static final String API_URL = "http://ergast.com/api/";
    private static final String F1_SERIES = "f1";
    private static final String SEASONS = "/seasons";
    private static final String RESULT_JSON = ".json";
    private static final String LIMIT_DATA = "limit=2000";
    private static final String RACE_RESULTS = "/results";

    public static String getSeasonList() {
        return API_URL + F1_SERIES + SEASONS + RESULT_JSON + "?" + LIMIT_DATA;
    }

    public static String getSeasonDetail(Season season) {
        return API_URL + F1_SERIES + "/" + season.getSeason() + RESULT_JSON + "?" + LIMIT_DATA;
    }
}