package com.arfirman1402.dev.wikif1.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 * Created by alodokter-it on 16/05/17 -- BaseAdapter.
 */

public abstract class BaseAdapter<Model, ViewHolder extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<ViewHolder> {
    private int adapterLayout;
    private Class<ViewHolder> mViewHolderClass;
    private ArrayList<Model> mData;

    public BaseAdapter(int adapterLayout, Class<ViewHolder> mViewHolderClass, ArrayList<Model> mData) {
        this.adapterLayout = adapterLayout;
        this.mViewHolderClass = mViewHolderClass;
        this.mData = mData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewGroup view = (ViewGroup) LayoutInflater.from(parent.getContext()).inflate(adapterLayout, parent, false);
        try {
            Constructor<ViewHolder> constructor = mViewHolderClass.getConstructor(View.class);
            return constructor.newInstance(view);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Model model = getItem(position);
        bindView(holder, model, position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public abstract void bindView(ViewHolder holder, Model model, int position);

    private Model getItem(int position) {
        return mData.get(position);
    }
}