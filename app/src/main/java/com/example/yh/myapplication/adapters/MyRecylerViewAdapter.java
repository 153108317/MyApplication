package com.example.yh.myapplication.adapters;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.yh.myapplication.MyApplication;
import com.example.yh.myapplication.R;
import com.example.yh.myapplication.base.BasicRecylerViewAdapter;
import com.example.yh.myapplication.base.RecylerViewHolder;
import com.example.yh.myapplication.entities.TestBean;
import com.example.yh.myapplication.utils.Utils;

import java.util.List;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/11 13:47
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class MyRecylerViewAdapter extends BasicRecylerViewAdapter<TestBean> {
    public MyRecylerViewAdapter(List<TestBean> list, int itemLayoutId) {
        super(list, itemLayoutId);
    }

    @Override
    protected void onConvert(RecylerViewHolder holder, final int position, TestBean testBean) {
        holder.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.Toast("pisition" + position);
            }
        });
        holder.setText(R.id.mtextview, testBean.getTitle());
        Glide.with(MyApplication.mApplicationContext).load(testBean.getImageurl()).into((ImageView) holder.getView(R.id.mimageview));
    }

}
