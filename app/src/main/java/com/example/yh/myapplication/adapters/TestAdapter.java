package com.example.yh.myapplication.adapters;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.yh.myapplication.MyApplication;
import com.example.yh.myapplication.R;
import com.example.yh.myapplication.base.BasicAdapter;
import com.example.yh.myapplication.base.Holder;
import com.example.yh.myapplication.result.TestBean;
import com.example.yh.myapplication.utils.Log;

import java.util.List;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/06 15:41
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class TestAdapter extends BasicAdapter<TestBean>{
    public TestAdapter(List<TestBean> list,int layoutId) {
        super(list,layoutId);
    }

    @Override
    public void convert(Holder holder, TestBean testBean) {

        Log.e("testBean.getTitle()"+testBean.getTitle());
        holder.setText(R.id.mtextview,""+testBean.getTitle());
        holder.setImage(R.id.mimageview,R.mipmap.ic_camera_r);
        /**\
         *
         * Glide
         .with(myFragment)
         .load(url)
         .centerCrop()
         .placeholder(R.drawable.loading_spinner)
         .crossFade()
         .into(myImageView);**/
        testBean.setImageurl("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg");
        Glide.with(MyApplication.mApplicationContext).load(testBean.getImageurl()).
                placeholder(R.mipmap.ic_launcher)
                .into((ImageView) holder.getView(R.id.mimageview));

    }
}
