package com.arfirman1402.dev.wikif1.util.model.race;

import com.arfirman1402.dev.wikif1.util.model.Circuit;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alodokter-it on 16/05/17 -- Race.
 */

public class Race {
    private String season;
    private String round;
    private String url;
    private String raceName;
    @SerializedName("Circuit")
    private Circuit circuit;
    private String date;

    public String getSeason() {
        return season;
    }

    public String getRound() {
        return round;
    }

    public String getUrl() {
        return url;
    }

    public String getRaceName() {
        return raceName;
    }

    public Circuit getCircuit() {
        return circuit;
    }

    public String getDate() {
        return date;
    }
}