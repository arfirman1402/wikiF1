package com.arfirman1402.dev.wikif1.activity.race.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.arfirman1402.dev.wikif1.App;
import com.arfirman1402.dev.wikif1.R;
import com.arfirman1402.dev.wikif1.activity.race.model.IRaceM;
import com.arfirman1402.dev.wikif1.activity.race.presenter.IRaceP;
import com.arfirman1402.dev.wikif1.activity.race.presenter.RaceP;
import com.arfirman1402.dev.wikif1.activity.race.view.holder.VHResult;
import com.arfirman1402.dev.wikif1.base.BaseActivity;
import com.arfirman1402.dev.wikif1.base.BaseAdapter;
import com.arfirman1402.dev.wikif1.base.BaseConstant;
import com.arfirman1402.dev.wikif1.util.model.race.Race;
import com.arfirman1402.dev.wikif1.util.model.race.Result;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;
import io.reactivex.observers.DisposableObserver;

/**
 * Created by arfirman1402 on 21/05/17.
 */

public class RaceActivity extends BaseActivity<IRaceM> implements RaceV {
    private Race race;
    private String TAG = this.getClass().getSimpleName();
    private RaceP presenter;

    @BindView(R.id.race_result_list)
    RecyclerView raceResultList;

    @BindView(R.id.race_round)
    TextView raceRound;

    @BindView(R.id.race_title)
    TextView raceTitle;

    @BindView(R.id.race_date)
    TextView raceDate;

    @BindView(R.id.race_location)
    TextView raceLocation;

    @BindView(R.id.race_result_date)
    TextView raceResultDate;

    private ArrayList<Result> raceResultDataList;
    private BaseAdapter<Result, VHResult> raceResultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_race);

        race = App.getInstance().getGson().fromJson(getIntent().getExtras().getString(BaseConstant.RACE_CODE), Race.class);
        Log.d(TAG, "bindData: " + race.getSeason() + " - " + race.getRaceName() + " - " + race.getDate() + " - " + race.getCircuit().getCircuitName() + ", " + race.getCircuit().getLocation().getLocality() + ", " + race.getCircuit().getLocation().getCountry());

        initView();

        presenter = new IRaceP(this);

        setSubscribe(presenter.getResult(race), new DisposableObserver<IRaceM>() {
            @Override
            public void onComplete() {
                Log.d(TAG, "onCompleted: has reached");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e.toString());
            }

            @Override
            public void onNext(IRaceM result) {
                raceResultDataList.clear();
                if (result.getRaceList().getRaceTable().getRaces().size() > 0) {
                    raceResultDataList.addAll(result.getRaceList().getRaceTable().getRaces().get(0).getResults());
                } else {
                    raceResultList.setVisibility(View.GONE);
                    raceResultDate.setVisibility(View.VISIBLE);
                    raceResultDate.setText("No Race results from server because race still unfinished or still unstarted. Please try again later.");
                }
                raceResultAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initView() {
        setTitle(race.getSeason() + " " + race.getRaceName());
        if (Integer.parseInt(race.getRound()) < 10) raceRound.setText("Round 0" + race.getRound());
        else raceRound.setText("Round " + race.getRound());
        raceTitle.setText(race.getRaceName());
        raceLocation.setText(race.getCircuit().getCircuitName() + ", " + race.getCircuit().getLocation().getLocality() + ", " + race.getCircuit().getLocation().getCountry());
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(race.getDate());
            String result = new SimpleDateFormat("EEE, dd MMMM yyyy", Locale.getDefault()).format(date);
            raceDate.setText(result);
        } catch (ParseException e) {
            e.printStackTrace();
            Log.d(TAG, "bindData: " + e.toString());
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        raceResultList.setHasFixedSize(true);
        raceResultList.setLayoutManager(layoutManager);
        raceResultList.setNestedScrollingEnabled(false);

        raceResultDataList = new ArrayList<>();

        raceResultAdapter = new BaseAdapter<Result, VHResult>(R.layout.adapter_race_result_list, VHResult.class, raceResultDataList) {
            @Override
            public void bindView(VHResult holder, final Result result, int position) {
                holder.bindData(result);
            }
        };

        raceResultList.setAdapter(raceResultAdapter);
    }
}