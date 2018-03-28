package com.mayi.video.bean;

import java.io.Serializable;

/**
 * Created by admin on 2018/3/28.
 */

public class VideoBean implements Serializable {
    private String title;
    private String name;
    private String img;
    private String videourl;

    public VideoBean(String title, String name, String img, String videourl) {
        this.title = title;
        this.name = name;
        this.img = img;
        this.videourl = videourl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideourl() {
        return videourl;
    }

    public void setVideourl(String videourl) {
        this.videourl = videourl;
    }
}
