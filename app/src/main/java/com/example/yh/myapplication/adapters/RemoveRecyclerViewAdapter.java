package com.example.yh.myapplication.adapters;

import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.base.BasicRecylerViewAdapter;
import com.example.yh.myapplication.base.RecylerViewHolder;
import com.example.yh.myapplication.entities.PictureBean;

import java.util.List;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/26 17:35
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class RemoveRecyclerViewAdapter extends BasicRecylerViewAdapter<PictureBean>{
    public RemoveRecyclerViewAdapter(List<PictureBean> list, int itmemLayoutId) {
        super(list, itmemLayoutId);
    }

    @Override
    protected void onConvert(RecylerViewHolder holder,  final int position, PictureBean s) {
        holder.setText(R.id.who,s.getWho());
        holder.setText(R.id._id,"getid:"+s.get_id());
        holder.setImage(R.id.mimageview,s.getUrl());
        holder.getView(R.id.layout).setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200));

    }
    public void delete(int position) {
        list.remove(position);
        notifyDataSetChanged();
    } public void removeItem(int position) {
        list.remove(position);
        notifyDataSetChanged();
    }
}
