package com.arfirman1402.dev.wikif1.activity.season.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.arfirman1402.dev.wikif1.App;
import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.activity.race.view.RaceActivity;
import com.arfirman1402.dev.wikif1.activity.season.model.ISeasonM;
import com.arfirman1402.dev.wikif1.activity.season.presenter.ISeasonP;
import com.arfirman1402.dev.wikif1.activity.season.presenter.SeasonP;
import com.arfirman1402.dev.wikif1.activity.season.view.holder.VHRace;
import com.arfirman1402.dev.wikif1.base.BaseActivity;
import com.arfirman1402.dev.wikif1.base.BaseAdapter;
import com.arfirman1402.dev.wikif1.base.BaseConstant;
import com.arfirman1402.dev.wikif1.util.model.race.Race;
import com.arfirman1402.dev.wikif1.util.model.season.Season;

import java.util.ArrayList;

import butterknife.BindView;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by alodokter-it on 17/05/17 -- SeasonActivity.
 */

public class SeasonActivity extends BaseActivity<ISeasonM> implements SeasonV {
    private String TAG = this.getClass().getSimpleName();
    private SeasonP presenter;
    private Season season;

    @BindView(R.id.season_race_list)
    RecyclerView seasonRaceList;
    private ArrayList<Race> seasonRaceDataList;
    private BaseAdapter<Race, VHRace> seasonRaceAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_season);

        season = App.getInstance().getGson().fromJson(getIntent().getExtras().getString(BaseConstant.SEASON_CODE), Season.class);
        Log.d(TAG, "onCreate: " + season.getSeason() + " - " + season.getUrl());

        initView();

        presenter = new ISeasonP(this);

        setSubscribe(presenter.getResult(season), new DisposableObserver<ISeasonM>() {
            @Override
            public void onComplete() {
                Log.d(TAG, "onCompleted: has Reached");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.toString());
            }

            @Override
            public void onNext(ISeasonM result) {
                seasonRaceDataList.clear();
                seasonRaceDataList.addAll(result.getRaceList().getRaceTable().getRaces());

                seasonRaceAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initView() {
        setTitle(season.getSeason());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        seasonRaceList.setHasFixedSize(true);
        seasonRaceList.setLayoutManager(layoutManager);

        seasonRaceDataList = new ArrayList<>();

        seasonRaceAdapter = new BaseAdapter<Race, VHRace>(R.layout.adapter_season_race_list, VHRace.class, seasonRaceDataList) {
            @Override
            public void bindView(VHRace holder, final Race race, int position) {
                holder.bindData(race);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.onClickList(race);
                    }
                });
            }
        };

        seasonRaceList.setAdapter(seasonRaceAdapter);
    }

    @Override
    public void openRace(Race race) {
        Log.d(TAG, "openRace: " + race.getSeason() + " - " + race.getDate() + " - " + race.getRaceName() + " - " + race.getCircuit().getCircuitName() + " - " + race.getCircuit().getLocation().getLocality() + " - " + race.getCircuit().getLocation().getCountry());
        Bundle bundle = new Bundle();
        bundle.putString(BaseConstant.RACE_CODE, App.getInstance().getGson().toJson(race));
        openNewActivity(RaceActivity.class, bundle, false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return true;
    }
}