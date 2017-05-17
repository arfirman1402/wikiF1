package com.arfirman1402.dev.wikif1.activity.season.model;

import com.arfirman1402.dev.wikif1.util.model.season.Season;

import okhttp3.Request;

/**
 * Created by alodokter-it on 17/05/17 -- SeasonM.
 */

public interface SeasonM {
    Request build(Season season);
}
