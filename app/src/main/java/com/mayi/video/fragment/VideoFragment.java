package com.mayi.video.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.mayi.video.R;
import com.mayi.video.adapter.VideoAdapter;
import com.mayi.video.base.BaseFragment;
import com.mayi.video.bean.VideoBean;
import com.mayi.video.utils.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by admin on 2018/3/14.
 * 视频
 */

public class VideoFragment extends BaseFragment {

    @BindView(R.id.rv_video)
    RecyclerView mRvVideo;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mRvVideo.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        //设置item间距，30dp
        mRvVideo.addItemDecoration(new SpaceItemDecoration(10));
        List<VideoBean> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(new VideoBean("不知说什么好", "@好好出去", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2903708291,4173810861&fm=27&gp=0.jpg", ""));
        }
        mRvVideo.setAdapter(new VideoAdapter(getActivity(), arr));
    }

}
