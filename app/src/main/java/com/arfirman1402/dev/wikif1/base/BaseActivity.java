package com.arfirman1402.dev.wikif1.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by alodokter-it on 16/05/17 -- BaseActivity.
 */

public class BaseActivity<T> extends AppCompatActivity {
    public Subscription subscription = new CompositeSubscription();

    protected void bind(int layout) {
        setContentView(layout);
        ButterKnife.bind(this);
    }

    protected void openNewActivity(Class dest, boolean isFinish) {
        Intent i = new Intent(this, dest);
        startActivity(i);
        if (isFinish) finish();
    }

    protected void setSubscribe(Observable<T> result, Observer<T> observer) {
        subscription = result
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(observer);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subscription.unsubscribe();
    }
}