package com.arfirman1402.dev.wikif1.base;

/**
 * Created by alodokter-it on 16/05/17 -- BaseModel.
 */

public class BaseModel {

    private String xmlns;
    private String series;
    private String url;
    private int limit;
    private int offset;
    private int total;

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
}