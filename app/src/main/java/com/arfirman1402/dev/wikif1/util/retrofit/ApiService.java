package com.arfirman1402.dev.wikif1.util.retrofit;

import com.arfirman1402.dev.wikif1.util.model.season.SeasonList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by arfirman1402 on 25/05/17.
 */

public interface ApiService {
    String API_URL = "http://ergast.com/api/f1/";

    @GET("seasons.json")
    Observable<SeasonList> getSeasonList(@Query("limit") int limit);

    @GET("{season}.json")
    Observable<SeasonList> getSeasonDetail(@Path("season") String season,  @Query("limit") int limit);
}
