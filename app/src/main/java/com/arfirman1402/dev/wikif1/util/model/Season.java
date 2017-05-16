package com.arfirman1402.dev.wikif1.util.model;

/**
 * Created by alodokter-it on 16/05/17 -- Season.
 */

public class Season {
    private String season;
    private String url;

    public Season(String season, String url) {
        this.season = season;
        this.url = url;
    }

    public String getSeason() {
        return season;
    }

    public String getUrl() {
        return url;
    }
}
