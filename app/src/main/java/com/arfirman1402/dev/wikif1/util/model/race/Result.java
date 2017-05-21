package com.arfirman1402.dev.wikif1.util.model.race;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arfirman1402 on 21/05/17.
 */

public class Result {
    private String number;
    private String position;
    private String positionText;
    private String points;
    @SerializedName("Driver")
    private Driver driver;
    @SerializedName("Constructor")
    private Constructor constructor;
    private String grid;
    private String laps;
    private String status;
    @SerializedName("Time")
    private Time time;

    public String getNumber() {
        return number;
    }

    public String getPosition() {
        return position;
    }

    public String getPositionText() {
        return positionText;
    }

    public String getPoints() {
        return points;
    }

    public Driver getDriver() {
        return driver;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public String getGrid() {
        return grid;
    }

    public String getLaps() {
        return laps;
    }

    public String getStatus() {
        return status;
    }

    public Time getTime() {
        return time;
    }
}
