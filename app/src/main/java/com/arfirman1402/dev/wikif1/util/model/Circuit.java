package com.arfirman1402.dev.wikif1.util.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alodokter-it on 16/05/17 -- Circuit.
 */

public class Circuit {
    private String circuitId;
    private String url;
    private String circuitName;
    private Location location;

    public Circuit(String circuitId, String url, String circuitName, Location location) {
        this.circuitId = circuitId;
        this.url = url;
        this.circuitName = circuitName;
        this.location = location;
    }

    public String getCircuitId() {
        return circuitId;
    }

    public String getUrl() {
        return url;
    }

    public String getCircuitName() {
        return circuitName;
    }

    public Location getLocation() {
        return location;
    }

    private class Location {
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
}
