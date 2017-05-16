package com.arfirman1402.dev.wikif1.util.model;

/**
 * Created by alodokter-it on 16/05/17 -- Race.
 */

public class Race {
    private String season;
    private String round;
    private String url;
    private String raceName;
    private Circuit circuit;
    private String date;
    private String time;

    public Race(String season, String round, String url, String raceName, Circuit circuit, String date, String time) {
        this.season = season;
        this.round = round;
        this.url = url;
        this.raceName = raceName;
        this.circuit = circuit;
        this.date = date;
        this.time = time;
    }

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

    public String getTime() {
        return time;
    }
}
