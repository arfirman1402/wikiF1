package com.arfirman1402.dev.wikif1.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by alodokter-it on 17/05/17 -- BaseHolder.
 */

public abstract class BaseHolder<Model> extends RecyclerView.ViewHolder {
    public BaseHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public abstract void bindData(Model data);
}
