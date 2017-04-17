package com.example.yh.myapplication.adapters;

import android.view.View;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.base.BasicRecylerViewAdapter;
import com.example.yh.myapplication.base.RecylerViewHolder;
import com.example.yh.myapplication.entities.PictureBean;
import com.example.yh.myapplication.utils.Utils;

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
    protected void onConvert(RecylerViewHolder holder, final int position, PictureBean pictureResult) {

        holder.setText(R.id.who,pictureResult.getWho());
        holder.setText(R.id._id,"getid:"+pictureResult.get_id());
        holder.setImage(R.id.mimageview,pictureResult.getUrl());
        holder.getRootView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Utils.Toast("position"+position);
            }
        });

    }
}
