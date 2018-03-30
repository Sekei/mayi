package com.mayi.video.fragment;

import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.mayi.video.R;
import com.mayi.video.base.BaseFragment;
import com.xiao.nicevideoplayer.LogUtil;
import com.xiao.nicevideoplayer.NiceVideoPlayer;
import com.xiao.nicevideoplayer.TxVideoPlayerController;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by admin on 2018/3/14.
 */

public class VideoPageFragment extends BaseFragment {

    @BindView(R.id.video_player)
    NiceVideoPlayer mVideoPlayer;

    private TxVideoPlayerController controller;

    int mNum; //页号

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_pager;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        mNum = getArguments() != null ? getArguments().getInt("num") : 1;
//        TextView tv = (TextView) view.findViewById(R.id.text);
//        tv.setText("页面" + mNum);

        mVideoPlayer.setPlayerType(NiceVideoPlayer.TYPE_NATIVE); // IjkPlayer or MediaPlayer
        controller = new TxVideoPlayerController(getActivity());
//        controller.setLenght(117000);
//        Glide.with(this).load("http://imgsrc.baidu.com/image/c0%3Dshijue%2C0%2C0%2C245%2C40/sign=304dee3ab299a9012f38537575fc600e/91529822720e0cf3f8b77cd50046f21fbe09aa5f.jpg")
//                .placeholder(R.drawable.img_default).crossFade().into(controller.imageView());
        mVideoPlayer.setController(controller);
        mVideoPlayer.setUp("http://play.g3proxy.lecloud.com/vod/v2/MjUxLzE2LzgvbGV0di11dHMvMTQvdmVyXzAwXzIyLTExMDc2NDEzODctYXZjLTE5OTgxOS1hYWMtNDgwMDAtNTI2MTEwLTE3MDg3NjEzLWY1OGY2YzM1NjkwZTA2ZGFmYjg2MTVlYzc5MjEyZjU4LTE0OTg1NTc2ODY4MjMubXA0?b=259&mmsid=65565355&tm=1499247143&key=f0eadb4f30c404d49ff8ebad673d3742&platid=3&splatid=345&playid=0&tss=no&vtype=21&cvid=2026135183914&payff=0&pip=08cc52f8b09acd3eff8bf31688ddeced&format=0&sign=mb&dname=mobile&expect=1&tag=mobile&xformat=super", null);
//        mVideoPlayer.start();//播放开始
//        mVideoPlayer.restart();//重新播放
//        LogUtil.d("播放了===========");
    }


    @OnClick({R.id.rl_video})
    public void onBindClick(View v) {
        switch (v.getId()) {
            case R.id.rl_video:
                controller.pause();
                break;
        }
    }

    public static VideoPageFragment newInstance(int num) {
        VideoPageFragment fragment = new VideoPageFragment();
        Bundle args = new Bundle();
        args.putInt("num", num);
        fragment.setArguments(args);
        return fragment;
    }
}
