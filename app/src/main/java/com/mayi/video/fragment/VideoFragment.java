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
        arr.add(new VideoBean("", "", "http://img4.imgtn.bdimg.com/it/u=1749854252,1785079208&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img4.imgtn.bdimg.com/it/u=2461973185,4082464345&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img2.imgtn.bdimg.com/it/u=1424502795,698140229&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img0.imgtn.bdimg.com/it/u=1926926120,1138529074&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img1.imgtn.bdimg.com/it/u=3818863168,1940730769&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img1.imgtn.bdimg.com/it/u=2274561811,796103394&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img3.imgtn.bdimg.com/it/u=190694684,1310750011&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img5.imgtn.bdimg.com/it/u=2249410907,246596508&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img2.imgtn.bdimg.com/it/u=1864764128,3224426032&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img1.imgtn.bdimg.com/it/u=4060727971,1007169628&fm=27&gp=0.jpg", ""));
        mRvVideo.setAdapter(new VideoAdapter(getActivity(), arr));
    }

}
