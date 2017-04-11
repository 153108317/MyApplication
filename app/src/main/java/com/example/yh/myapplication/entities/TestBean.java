package com.example.yh.myapplication.entities;

import com.example.yh.myapplication.base.BasicResult;
import com.example.yh.myapplication.result.Weatherinfo;

import java.util.List;

/**
 * Created by yh on 2017/3/31.
 */

public class TestBean extends BasicResult{
    private String title;
    private String content;
    private String url;
    private String imageurl;
    private List<TestBean> list;

    public List<TestBean> getList() {
        return list;
    }

    public void setList(List<TestBean> list) {
        this.list = list;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    private int imgId;
private Weatherinfo weatherinfo;

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public Weatherinfo getWeatherinfo() {
        return weatherinfo;
    }

    public void setWeatherinfo(Weatherinfo weatherinfo) {
        this.weatherinfo = weatherinfo;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
