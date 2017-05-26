package com.arfirman1402.dev.wikif1.util.model.race;

import com.google.gson.annotations.SerializedName;

/**
 * Created by alodokter-it on 16/05/17 -- Circuit.
 */

public class Circuit {
    private String circuitId;
    private String url;
    private String circuitName;
    @SerializedName("Location")
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
}