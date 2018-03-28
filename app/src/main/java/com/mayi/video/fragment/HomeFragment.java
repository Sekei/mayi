package com.mayi.video.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;


import com.androidkun.xtablayout.XTabLayout;
import com.mayi.video.R;
import com.mayi.video.adapter.TabAdapter;
import com.mayi.video.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by MissSekei on 2018/1/12.
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.xtab)
    XTabLayout mXTab;
    @BindView(R.id.vp_home_title)
    ViewPager viewPager;
    private String[] titles = {"直播", "视频", "同城"};

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        List<Fragment> list = new ArrayList<>();
        list.add(new SpotVideoFragment());
        list.add(new VideoFragment());
        list.add(new VideoFragment());
        TabAdapter adapter = new TabAdapter(getActivity().getSupportFragmentManager(), titles, list);
        viewPager.setAdapter(adapter);
        mXTab.setupWithViewPager(viewPager);  //绑定
    }
}
