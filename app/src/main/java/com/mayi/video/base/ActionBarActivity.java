package com.mayi.video.base;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.mayi.video.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;


public abstract class ActionBarActivity extends BaseActivity implements IBaseView, View.OnClickListener {

    protected TextView mTitle, mTvRight;
    protected RelativeLayout mBack, mHeadTopColor;


    //界面样式风格
    public static final int ACTIONBAR_DARK = 0;//状态栏透明
    public static final int ACTIONBAR_WHITE = 1;//默认风格
    public static final int ACTIONBAR_TRANSLATE = 2;//首页Page

    //Loading加载框
    //protected LoadingDialog loadingView;

    //存放正在show的dialog
    private Map<Object, Boolean> mapDialog = new HashMap<>();

    //界面view
    protected abstract int getLayoutId();

    //界面风格
    protected int getActionBarType() {
        return ACTIONBAR_WHITE;
    }

    //状态栏颜色
    protected int getStatusBarTintResource() {
        return R.color.colorPrimary;
    }

    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {
    }

    @Override
    public void showToast(String content) {
        Toast.makeText(this, content, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initActionBar();
        initView();
    }

    // view初始化
    protected void initActionBar() {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 锁定竖屏
        setContentView(getLayoutId());
        //初始化BUtterKnife框架，可写在项目基类里面。
        ButterKnife.bind(this);
        if (getActionBarType() == ACTIONBAR_DARK) { //透明风格设计
            setStatusBarColor();//通知栏透明
        } else if (getActionBarType() == ACTIONBAR_WHITE) {//默认风格
        }
    }


    // 操作
    protected void initView() {

    }

    //生命周期,主要用于数据统计分析，如页面停留时间，打开次数等
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void onClick(View view) {
        switch (view.getId()) {

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
