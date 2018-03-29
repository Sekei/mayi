package com.mayi.video.adapter;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import com.mayi.video.R;
import com.mayi.video.act.MainActivity;
import com.mayi.video.base.CommonRecycleAdapter;
import com.mayi.video.base.CommonViewHolder;
import com.mayi.video.bean.VideoBean;
import com.mayi.video.utils.GlideImageLoader;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2018/2/24.
 */

public class VideoAdapter extends CommonRecycleAdapter<VideoBean> implements CommonViewHolder.onItemCommonClickListener {

    private Context mContext;

    public VideoAdapter(Context context, List<VideoBean> dataList) {
        super(context, dataList, R.layout.item_video);
        this.mContext = context;
    }

    @Override
    public void bindData(CommonViewHolder holder, VideoBean data) {
        holder.setCommonClickListener(this);
        GlideImageLoader mImage = new GlideImageLoader();
        mImage.displayImage(mContext, data.getImg(), (ImageView) holder.getView(R.id.iv_img));
    }

    @Override
    public void onItemClickListener(int position) {
        mContext.startActivity(new Intent(mContext, MainActivity.class));
    }

    @Override
    public void onItemLongClickListener(int position) {

    }

}
