package com.arfirman1402.dev.wikif1.util.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alodokter-it on 18/05/17 -- Location.
 */

public class Location {
    private double lat;
    @SerializedName("long")
    private double lon;
    private String locality;
    private String country;

    public Location(double lat, double lon, String locality, String country) {
        this.lat = lat;
        this.lon = lon;
        this.locality = locality;
        this.country = country;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getLocality() {
        return locality;
    }

    public String getCountry() {
        return country;
    }

}
