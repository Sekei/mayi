package com.mayi.video.base;

/**
 * 基类接口，提示和logding框
 * 控制Toast、progress
 */
public interface IBaseView {
    void showProgress();

    void hideProgress();

    void showToast(String content);

}
