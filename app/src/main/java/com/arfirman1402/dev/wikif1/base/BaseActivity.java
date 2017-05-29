package com.arfirman1402.dev.wikif1.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by alodokter-it on 16/05/17 -- BaseActivity.
 */

public class BaseActivity<T> extends AppCompatActivity {
    public CompositeDisposable subscription = new CompositeDisposable();

    protected void bind(int layout) {
        setContentView(layout);
        ButterKnife.bind(this);
    }

    protected void openNewActivity(Class dest, boolean isFinish) {
        openNewActivity(dest, new Bundle(), isFinish);
    }

    protected void openNewActivity(Class dest, Bundle extras, boolean isFinish) {
        Intent i = new Intent(this, dest);
        i.putExtras(extras);
        startActivity(i);
        if (isFinish) finish();
    }

    protected void setSubscribe(Observable<T> result, DisposableObserver<T> observer) {
        subscription.add(result
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribeWith(observer));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscription.clear();
    }
}