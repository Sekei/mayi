package com.mayi.video.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/2/24.
 */

public abstract class CommonRecycleAdapter<T> extends RecyclerView.Adapter<CommonViewHolder> {

    protected LayoutInflater layoutInflater;

    protected List<T> dataList;

    protected int layoutId;

    protected View itemView;

    public CommonRecycleAdapter(Context context, List<T> data, int layoutId) {
        this.layoutInflater = LayoutInflater.from(context);
        this.dataList = data == null ? new ArrayList<T>() : new ArrayList<T>(data);
        this.layoutId = layoutId;
    }

    public void getNotifyDataSetChanged(List<T> data) {
        this.dataList = data == null ? new ArrayList<T>() : new ArrayList<T>(data);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = layoutInflater.inflate(layoutId, parent, false);
        return new CommonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        bindData(holder, dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public abstract void bindData(CommonViewHolder holder, T data);
}
