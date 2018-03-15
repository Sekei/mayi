package com.mayi.video.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mayi.video.R;
import com.mayi.video.base.BaseFragment;

/**
 * Created by admin on 2018/3/14.
 */

public class MyFragment extends BaseFragment {

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

    public static MyFragment newInstance(int num) {
        MyFragment fragment = new MyFragment();
        Bundle args = new Bundle();
        args.putInt("num", num);
        fragment.setArguments(args);
        return fragment;
    }
}
