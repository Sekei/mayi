package com.mayi.video.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;
import com.youth.banner.loader.ImageLoader;


/**
 * Created by admin on 2018/1/31.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        if (Util.isOnMainThread())
            Glide.with(context).load(path).into(imageView);
    }
}
