package com.mayi.video.fragment;

import android.os.Bundle;
import android.view.View;

import com.mayi.video.R;
import com.mayi.video.base.BaseFragment;

/**
 * Created by admin on 2018/3/14.
 */

public class VideoPageFragment extends BaseFragment {

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
    }

    public static VideoPageFragment newInstance(int num) {
        VideoPageFragment fragment = new VideoPageFragment();
        Bundle args = new Bundle();
        args.putInt("num", num);
        fragment.setArguments(args);
        return fragment;
    }
}
