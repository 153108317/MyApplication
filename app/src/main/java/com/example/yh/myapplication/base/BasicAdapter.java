package com.example.yh.myapplication.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/06 15:33
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public abstract class BasicAdapter<T extends BasicResult> extends BaseAdapter {
    private List<T> list;

    private int mLayoutId;
    public BasicAdapter(List<T> list,int layoutId) {
        this.list = list;
        this.mLayoutId=layoutId;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public T getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder=Holder.getInstance(mLayoutId,view,i);
        convert(holder,list.get(i));
        return holder.getRootView();
    }
    public abstract  void convert(Holder holder ,T t);

}
