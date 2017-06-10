package com.arfirman1402.dev.wikif1.util.retrofit;

import com.arfirman1402.dev.wikif1.activity.race.model.IRaceM;
import com.arfirman1402.dev.wikif1.newactivity.main.model.IMainM;
import com.arfirman1402.dev.wikif1.newactivity.splash.model.ISplashM;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by arfirman1402 on 25/05/17.
 */

public interface ApiService {
    String API_URL = "https://ergast.com/api/f1/";
    int DATA_LIMIT = 2000;

    @GET("seasons.json")
    Observable<ISplashM> getSplashSeasonList(@Query("limit") int limit);

    @GET("{season}.json")
    Observable<IMainM> getSeasonDetail(@Path("season") String season, @Query("limit") int limit);

    @GET("{season}/{round}/results.json")
    Observable<IRaceM> getRaceResult(@Path("season") String season, @Path("round") String round, @Query("limit") int limit);
}