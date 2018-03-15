package com.mayi.video.base;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.mayi.video.MyApp;


/**
 * Created by admin on 2018/2/24.
 */

public class CommonViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener, View.OnClickListener {

    // SparseArray 比 HashMap 更省内存，在某些条件下性能更好，只能存储 key 为 int 类型的数据，
    // 用来存放 View 以减少 findViewById 的次数
    private SparseArray<View> viewSparseArray;

    public onItemCommonClickListener commonClickListener;

    public CommonViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        itemView.setOnLongClickListener(this);
        viewSparseArray = new SparseArray<>();
    }

    /**
     * 根据 ID 来获取 View
     *
     * @param viewId viewID
     * @param <T>    泛型
     * @return 将结果强转为 View 或 View 的子类型
     */
    public <T extends View> T getView(int viewId) {
        // 先从缓存中找，找打的话则直接返回
        // 如果找不到则 findViewById ，再把结果存入缓存中
        View view = viewSparseArray.get(viewId);
        if (view == null) {
            view = itemView.findViewById(viewId);
            viewSparseArray.put(viewId, view);
        }
        return (T) view;
    }

    /**
     * Set a view visibility to VISIBLE (true) or GONE (false).
     *
     * @param viewId  The view id.
     * @param visible True for VISIBLE, false for GONE.
     * @return The BaseAdapterHelper for chaining.
     */
    public CommonViewHolder setVisible(int viewId, boolean visible) {
        View view = getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }


    public CommonViewHolder setText(int viewId, CharSequence text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public CommonViewHolder setCheckBox(int viewId, boolean check) {
        CheckBox tv = getView(viewId);
        tv.setChecked(check);
        return this;
    }

    public CommonViewHolder setTextColor(int viewId, int textColor) {
        TextView view = getView(viewId);
        view.setTextColor(MyApp.getInstance().getResources().getColor(textColor));
        return this;
    }

    public CommonViewHolder setViewVisibility(int viewId, int visibility) {
        getView(viewId).setVisibility(visibility);
        return this;
    }

    public CommonViewHolder setImageResource(int viewId, int resourceId) {
        ImageView imageView = getView(viewId);
        imageView.setImageResource(resourceId);
        return this;
    }

    public CommonViewHolder setImageBackground(int viewId, int drawable) {
        ImageView view = getView(viewId);
        view.setBackgroundResource(drawable);
        return this;
    }

    public CommonViewHolder setBackgroundColor(int viewId, int color) {
        View view = getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public interface onItemCommonClickListener {

        void onItemClickListener(int position);

        void onItemLongClickListener(int position);

    }

    public void setCommonClickListener(onItemCommonClickListener commonClickListener) {
        this.commonClickListener = commonClickListener;
    }

    @Override
    public void onClick(View v) {
        if (commonClickListener != null) {
            commonClickListener.onItemClickListener(getAdapterPosition());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (commonClickListener != null) {
            commonClickListener.onItemLongClickListener(getAdapterPosition());
        }
        return false;
    }
}
