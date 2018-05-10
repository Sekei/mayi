package com.mayi.video.act;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.mayi.video.R;
import com.mayi.video.base.ActionBarActivity;
import com.mayi.video.fragment.FollowFragment;
import com.mayi.video.fragment.HomeFragment;
import com.mayi.video.fragment.MyFragment;
import com.mayi.video.fragment.NewsFragment;

import butterknife.BindView;

public class HomeAct extends ActionBarActivity implements RadioGroup.OnCheckedChangeListener {
    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    @BindView(R.id.home_radio_group)
    RadioGroup mRadioGroup;
    @BindView(R.id.home_radio_page)
    RadioButton mRadioButtonHome;
    private Fragment[] mFragmensts = new Fragment[4];
    private Fragment mFragment = null;


    @Override
    protected int getActionBarType() {
        return ACTIONBAR_TRANSLATE;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }


    @Override
    protected void initView() {
        super.initView();
        mFragmensts[0] = new HomeFragment();//首页
        mFragmensts[1] = new FollowFragment();//关注
        mFragmensts[2] = new NewsFragment();//消息
        mFragmensts[3] = new MyFragment();//我的
        mRadioGroup.setOnCheckedChangeListener(this);
        mRadioButtonHome.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.home_radio_page:
                mFragment = mFragmensts[0];
                break;
            case R.id.home_radio_choose:
                mFragment = mFragmensts[1];
                break;
            case R.id.home_radio_expert:
                mFragment = mFragmensts[2];
                break;
            case R.id.home_radio_my:
                mFragment = mFragmensts[3];
                break;
        }
        if (mFragmensts != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.home_container, mFragment).commit();
        }
    }


    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {
                    showToast("再按一次退出程序");
                    firstTime = secondTime;
                    return true;
                } else {
                    System.exit(0);
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }
}
