package com.arfirman1402.dev.wikif1.newactivity.main.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.arfirman1402.dev.wikif1.App;
import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.base.BaseActivity;
import com.arfirman1402.dev.wikif1.base.BaseAdapter;
import com.arfirman1402.dev.wikif1.base.BaseConstant;
import com.arfirman1402.dev.wikif1.newactivity.main.model.IMainM;
import com.arfirman1402.dev.wikif1.newactivity.main.presenter.IMainP;
import com.arfirman1402.dev.wikif1.newactivity.main.presenter.MainP;
import com.arfirman1402.dev.wikif1.newactivity.main.view.holder.VHSeason;
import com.arfirman1402.dev.wikif1.newactivity.season.view.SeasonActivity;
import com.arfirman1402.dev.wikif1.util.model.race.Race;
import com.arfirman1402.dev.wikif1.util.model.season.Season;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import io.reactivex.observers.DisposableObserver;

public class MainActivity extends BaseActivity<IMainM> implements MainV {

    @BindView(R.id.main_season_list)
    RecyclerView mainSeasonList;
    private ArrayList<Season> seasonDataList;
    private BaseAdapter<Season, VHSeason> seasonAdapter;
    private MainP presenter;
    private String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_main);

        initView();

        List<Season> seasons = Arrays.asList(App.getInstance().getGson().fromJson(getIntent().getExtras().getString("seasons"), Season[].class));

        seasonDataList.clear();
        seasonDataList.addAll(seasons);

        seasonAdapter.notifyDataSetChanged();

        presenter = new IMainP(this);
    }

    private void initView() {
        setTitle("Formula One - F1");

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
    public void getData(final Season season) {
        setSubscribe(presenter.getResult(season), new DisposableObserver<IMainM>() {
            @Override
            public void onError(Throwable error) {
                Log.d(TAG, "onError: " + error.toString());
            }

            @Override
            public void onNext(final IMainM result) {
                Log.d(TAG, "onNext: " + App.getInstance().getGson().toJson(result.getRaceList().getRaceTable().getRaces()));
                openSeason(result.getRaceList().getRaceTable().getRaces(), season);
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onCompleted: Has reached");
            }
        });
    }

    private void openSeason(ArrayList<Race> races, Season season) {
        Bundle bundle = new Bundle();
        bundle.putString("races", App.getInstance().getGson().toJson(races));
        bundle.putString(BaseConstant.SEASON_CODE, App.getInstance().getGson().toJson(season));
        openNewActivity(SeasonActivity.class, bundle, false);
    }
}