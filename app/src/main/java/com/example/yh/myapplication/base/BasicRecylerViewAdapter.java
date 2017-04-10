package com.example.yh.myapplication.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/08 09:55
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class BasicRecylerViewAdapter<T> extends RecyclerView.Adapter {
    private List<T> list;
    public BasicRecylerViewAdapter(List<T> list){///

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
