package com.mayi.video.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by admin on 2018/3/12.
 */

public class TabAdapter extends FragmentPagerAdapter {
    private String[] titles;
    private List<Fragment> list;

    public TabAdapter(FragmentManager fm, String[] titles, List<Fragment> list) {
        super(fm);
        this.titles = titles;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    //重写这个方法，将设置每个Tab的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}