package com.mayi.video.fragment;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.mayi.video.R;
import com.mayi.video.adapter.SpotVideoAdapter;
import com.mayi.video.adapter.VideoAdapter;
import com.mayi.video.base.BaseFragment;
import com.mayi.video.bean.VideoBean;
import com.mayi.video.utils.GlideImageLoader;
import com.mayi.video.utils.SpaceItemDecoration;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by MissSekei on 2018/1/12.
 * 直播
 */

public class SpotVideoFragment extends BaseFragment implements OnBannerListener {

    @BindView(R.id.home_banner)
    Banner mHomeBanner;
    @BindView(R.id.rv_spotvideo)
    RecyclerView mRvSpotVideo;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_spotvideo;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mHomeBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);//指示器模式
        mHomeBanner.setImageLoader(new GlideImageLoader());//设置图片加载器
        mHomeBanner.setIndicatorGravity(BannerConfig.RIGHT);//设置指示器位置（当banner模式中有指示器时）
        mHomeBanner.setOnBannerListener(this);
        List<String> images = new ArrayList<>();
        images.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1334109410,3380688181&fm=27&gp=0.jpg");
        images.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=638704354,2125557891&fm=27&gp=0.jpg");
        images.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2066946055,4071695867&fm=27&gp=0.jpg");
        images.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1897415358,3561817997&fm=27&gp=0.jpg");
        mHomeBanner.setImages(images);//设置图片集合
        mHomeBanner.start();//banner设置方法全部调用完毕时最后调用
        //直播列表展示
        mRvSpotVideo.setNestedScrollingEnabled(false);
        mRvSpotVideo.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        mRvSpotVideo.addItemDecoration(new SpaceItemDecoration(10));//设置item间距
        List<VideoBean> arr = new ArrayList<>();
        arr.add(new VideoBean("", "", "http://img5.imgtn.bdimg.com/it/u=3996570745,3915371036&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img2.imgtn.bdimg.com/it/u=4292769579,3818176239&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img0.imgtn.bdimg.com/it/u=3593429503,2723687451&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img4.imgtn.bdimg.com/it/u=2398241401,2139197401&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img5.imgtn.bdimg.com/it/u=4284473700,1365394059&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img4.imgtn.bdimg.com/it/u=3093385083,2915303339&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img0.imgtn.bdimg.com/it/u=3646232460,1248058942&fm=27&gp=0.jpg", ""));
        arr.add(new VideoBean("", "", "http://img1.imgtn.bdimg.com/it/u=729148239,4015690160&fm=27&gp=0.jpg", ""));
        mRvSpotVideo.setAdapter(new SpotVideoAdapter(getActivity(), arr));
    }

    /**
     * 广告位点击事件
     *
     * @param position
     */
    @Override
    public void OnBannerClick(int position) {
        // startActivity(ShareWebAct.class, "http://www.artpollo.com/Artwork/ArtworkDetails?id=2224886");
    }
}
