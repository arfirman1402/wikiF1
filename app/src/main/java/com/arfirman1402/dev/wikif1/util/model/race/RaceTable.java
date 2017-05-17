package com.arfirman1402.dev.wikif1.util.model.race;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by alodokter-it on 16/05/17 -- SeasonTable.
 */

public class RaceTable {
    @SerializedName("Races")
    private ArrayList<Race> races;

    public ArrayList<Race> getRaces() {
        return races;
    }
}