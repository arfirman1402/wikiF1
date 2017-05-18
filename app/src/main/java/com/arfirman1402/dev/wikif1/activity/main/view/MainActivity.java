package com.arfirman1402.dev.wikif1.activity.main.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.arfirman1402.dev.wikif1.App;
import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.activity.main.model.IMainM;
import com.arfirman1402.dev.wikif1.activity.main.presenter.IMainP;
import com.arfirman1402.dev.wikif1.activity.main.presenter.MainP;
import com.arfirman1402.dev.wikif1.activity.main.view.holder.VHSeason;
import com.arfirman1402.dev.wikif1.activity.season.view.SeasonActivity;
import com.arfirman1402.dev.wikif1.base.BaseActivity;
import com.arfirman1402.dev.wikif1.base.BaseAdapter;
import com.arfirman1402.dev.wikif1.base.BaseConstant;
import com.arfirman1402.dev.wikif1.util.model.season.Season;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends BaseActivity<IMainM> implements MainV {
    private final String TAG = getClass().getSimpleName();

    @BindView(R.id.main_season_list)
    RecyclerView mainSeasonList;
    private ArrayList<Season> seasonDataList;
    private BaseAdapter<Season, VHSeason> seasonAdapter;
    private MainP presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_main);

        initView();

        presenter = new IMainP(this);

        setSubscribe(presenter.getResult(), this);
    }

    private void initView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mainSeasonList.setHasFixedSize(true);
        mainSeasonList.setLayoutManager(layoutManager);

        seasonDataList = new ArrayList<>();

        seasonAdapter = new BaseAdapter<Season, VHSeason>(R.layout.adapter_main_season_list, VHSeason.class, seasonDataList) {
            @Override
            public void bindView(VHSeason holder, final Season season, int position) {
                holder.bindData(season);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        presenter.onClickList(season);
                    }
                });
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
        seasonDataList.addAll(result.getSeasonList().getSeasonTable().getSeasons());

        seasonAdapter.notifyDataSetChanged();
    }

    @Override
    public void openSeason(Season season) {
        Bundle bundle = new Bundle();
        bundle.putString(BaseConstant.SEASON_CODE, App.getInstance().getGson().toJson(season));
        openNewActivity(SeasonActivity.class, bundle, false);
    }

    @Override
    public void onCompleted() {
        Log.d(TAG, "onCompleted: Has reached");
    }
}