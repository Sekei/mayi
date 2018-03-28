package com.mayi.video.fragment;

import android.os.Bundle;
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
 * 关注
 */

public class FollowFragment extends BaseFragment {

    @BindView(R.id.rv_video)
    RecyclerView mRvVideo;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_follow;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mRvVideo.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        //设置item间距，30dp
        mRvVideo.addItemDecoration(new SpaceItemDecoration(10));
        List<VideoBean> arr = new ArrayList<>();
        arr.add(new VideoBean("不知说什么好", "@好好出去", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2903708291,4173810861&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3953222029,947888612&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3953468641,3148993378&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1626078464,505535105&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2091747130,1959072992&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3047379139,2164593581&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=4053517463,3283913509&fm=27&gp=0.jpg", ""));
        mRvVideo.setAdapter(new VideoAdapter(getActivity(), arr));
    }

}
