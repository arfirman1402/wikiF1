package com.arfirman1402.dev.wikif1.util.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alodokter-it on 16/05/17 -- MRData.
 */

public class MRData {
    private String xmlns;
    private String series;
    private String url;
    private int limit;
    private int offset;
    private int total;
    @SerializedName("SeasonTable")
    private SeasonTable seasonTable;

    public String getXmlns() {
        return xmlns;
    }

    public String getSeries() {
        return series;
    }

    public String getUrl() {
        return url;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public int getTotal() {
        return total;
    }

    public SeasonTable getSeasonTable() {
        return seasonTable;
    }
}