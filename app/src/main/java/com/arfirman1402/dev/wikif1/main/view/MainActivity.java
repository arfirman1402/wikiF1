package com.arfirman1402.dev.wikif1.main.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.base.BaseActivity;
import com.arfirman1402.dev.wikif1.base.BaseAdapter;
import com.arfirman1402.dev.wikif1.main.model.IMainM;
import com.arfirman1402.dev.wikif1.main.presenter.IMainP;
import com.arfirman1402.dev.wikif1.main.presenter.MainP;
import com.arfirman1402.dev.wikif1.main.view.holder.VHSeason;
import com.arfirman1402.dev.wikif1.util.model.Season;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity<IMainM> implements MainV {
    private final String TAG = getClass().getSimpleName();

    @BindView(R.id.main_season_list)
    RecyclerView mainSeasonList;
    private ArrayList<Season> seasonDataList;
    private BaseAdapter<Season, VHSeason> seasonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_main);

        MainP presenter = new IMainP(this);

        setSubscribe(presenter.getResult(), this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mainSeasonList.setHasFixedSize(true);
        mainSeasonList.setLayoutManager(layoutManager);

        seasonDataList = new ArrayList<>();

        seasonAdapter = new BaseAdapter<Season, VHSeason>(R.layout.adapter_main_season_list, VHSeason.class, seasonDataList) {
            @Override
            public void bindView(VHSeason holder, Season season, int position) {
                holder.bindData(season);
            }
        };

        mainSeasonList.setAdapter(seasonAdapter);
    }

    @Override
    public void onError(Throwable error) {
        Log.d(TAG, "onError: " + error.toString());
    }

    @Override
    public void onNext(final IMainM result) {
        seasonDataList.clear();
        seasonDataList.addAll(result.getMrData().getSeasonTable().getSeasons());

        seasonAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCompleted() {
        Log.d(TAG, "onCompleted: Has reached");
    }
}