package com.example.yh.myapplication.base;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.yh.myapplication.MyApplication;

import java.util.List;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/08 09:55
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public abstract class BasicRecylerViewAdapter<T> extends RecyclerView.Adapter <RecylerViewHolder>{
    private List<T> list;
    private int itmemLayoutId;
    public BasicRecylerViewAdapter(List<T> list,int itmemLayoutId){
        if(list==null){
            throw  new NullPointerException("BasicRecylerViewAdapter :list 为空");
        }
        this.list=list;
        this.itmemLayoutId=itmemLayoutId;
    }
    @Override
    public RecylerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecylerViewHolder recylerViewHolder=new RecylerViewHolder(View.inflate(MyApplication.mApplicationContext,itmemLayoutId,null));
       View v= View.inflate(MyApplication.mApplicationContext,itmemLayoutId,null);

        return recylerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecylerViewHolder holder, int position) {

        onConvert( holder,  position,list.get(position));
    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }
    protected abstract  void onConvert(RecylerViewHolder holder, int position,T t);
}
