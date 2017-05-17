package com.arfirman1402.dev.wikif1.util.model.season;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by alodokter-it on 16/05/17 -- SeasonTable.
 */

public class SeasonTable {
    @SerializedName("Seasons")
    private ArrayList<Season> seasons;

    public ArrayList<Season> getSeasons() {
        return seasons;
    }
}