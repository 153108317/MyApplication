package com.example.yh.myapplication.adapters;

import com.example.yh.myapplication.base.BasicRecylerViewAdapter;
import com.example.yh.myapplication.base.RecylerViewHolder;
import com.example.yh.myapplication.entities.PictureBean;

import java.util.List;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/11 17:12
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class Picture1RecylerViewAdapter extends BasicRecylerViewAdapter<PictureBean> {
    public Picture1RecylerViewAdapter(List<PictureBean> list, int itmemLayoutId) {
        super(list, itmemLayoutId);
    }

    @Override
    protected void onConvert(RecylerViewHolder holder, int position, PictureBean pictureResult) {

    }
}
