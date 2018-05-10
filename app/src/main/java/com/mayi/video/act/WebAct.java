package com.mayi.video.act;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;


import com.mayi.video.R;
import com.mayi.video.base.ActionBarActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by admin on 2018/2/2.
 */
@SuppressLint("SetJavaScriptEnabled")
public class WebAct extends ActionBarActivity{

    @BindView(R.id.web_view)
    WebView mWebView;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_web;
    }

    @Override
    protected void initView() {
        super.initView();
        // 设置不调用外部浏览器
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new WebChromeClient());
        CookieSyncManager.createInstance(this);
        CookieManager cn = CookieManager.getInstance();
        cn.removeSessionCookie();
        cn.removeAllCookie();
        // 是否可以缩放
        WebSettings settings = mWebView.getSettings();
        settings.setSupportZoom(false);
        // 是否显示缩放控制
        settings.setBuiltInZoomControls(false);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        //页面加载
        mWebView.loadUrl("http://h.open.huajiao.com/l/openhuajiao?channelid=hjgongzhonghao");
    }

    public class WebViewClient extends android.webkit.WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url != null && url.startsWith("mailto:") || url.startsWith("geo:") || url.startsWith("tel:")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }
            return false;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

    }

    public class WebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
//            if (newProgress < 100) {
//                if (mProgressBar.getVisibility() == View.GONE)
//                    mProgressBar.setVisibility(View.VISIBLE);
//                mProgressBar.setProgress(newProgress);
//            } else {
//                mProgressBar.setProgress(100);
//                AlphaAnimation animation = new AlphaAnimation(1, 0);
//                animation.setDuration(1000);
//                mProgressBar.startAnimation(animation);
//                mProgressBar.setVisibility(View.GONE);
//            }
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            mTitle.setText(title);
        }
    }


    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }

}
