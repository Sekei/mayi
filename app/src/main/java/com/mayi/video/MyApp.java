package com.mayi.video;

import android.app.Application;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2018/1/15.
 */
public class MyApp extends Application {
    //应用实例
    private static MyApp instance;
    // 获取屏幕分辨率
    private DisplayMetrics mDisplay = new DisplayMetrics();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        mDisplay = this.getResources().getDisplayMetrics();
    }

    //获得实例
    public static MyApp getInstance() {
        return instance;
    }

    public float getDisplayDensity() {
        return mDisplay.density;
    }

    public int dp2px(int dp) {
        return (int) (dp * getDisplayDensity() + 0.5f);
    }

    public int px2dp(int px) {
        return (int) (px / getDisplayDensity() + 0.5f);
    }

    public int pxToSp(int px) {
        return (int) (px / mDisplay.scaledDensity);
    }

    public int spToPx(int sp) {
        return (int) (sp * mDisplay.scaledDensity);
    }

    /**
     * 获取 屏幕像素 px
     *
     * @return Integer[高度，宽度]
     */
    public int[] getDisplayHightAndWightPx() {
        return new int[]{mDisplay.heightPixels, mDisplay.widthPixels};
    }
}
