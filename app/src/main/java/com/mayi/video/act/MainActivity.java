package com.mayi.video.act;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mayi.video.R;
import com.mayi.video.base.ActionBarActivity;
import com.mayi.video.fragment.MyFragment;
import com.mayi.video.widget.VerticalViewPager;

import butterknife.BindView;

public class MainActivity extends ActionBarActivity {

    @BindView(R.id.viewpager)
    VerticalViewPager mViewPager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getActionBarType() {
        return ACTIONBAR_DARK;
    }

    @Override
    protected void initView() {
        super.initView();
        FragmentManager fm = getSupportFragmentManager();
        //初始化自定义适配器
        MyFragmentPageAdapter mAdapter = new MyFragmentPageAdapter(fm);
        //绑定自定义适配器
        mViewPager.setAdapter(mAdapter);
    }

    class MyFragmentPageAdapter extends FragmentPagerAdapter {
        public MyFragmentPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 25;
        }

        @Override
        public Fragment getItem(int position) {
            return MyFragment.newInstance(position);
        }
    }
}
