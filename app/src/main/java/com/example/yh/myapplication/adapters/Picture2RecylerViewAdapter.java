package com.example.yh.myapplication.adapters;

import android.view.View;

import com.example.yh.myapplication.base.BasicRecylerViewAdapter;
import com.example.yh.myapplication.base.RecylerViewHolder;
import com.example.yh.myapplication.entities.PictureBean;
import com.example.yh.myapplication.utils.Utils;

import java.util.List;

/**
 * Fixme
 * Author: PengHong
 * Date: 2017/04/17 14:34
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class Picture2RecylerViewAdapter extends BasicRecylerViewAdapter<PictureBean>{
    public Picture2RecylerViewAdapter(List<PictureBean> list, int itmemLayoutId) {
        super(list, itmemLayoutId);
    }
    @Override
    protected void onConvert(RecylerViewHolder holder, final int position, PictureBean pictureResult) {
            holder.getRootView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Utils.Toast("position"+position);
                }
            });
    }
}
