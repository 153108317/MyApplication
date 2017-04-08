package com.example.yh.myapplication.adapters;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yh.myapplication.MyApplication;
import com.example.yh.myapplication.R;
import com.example.yh.myapplication.result.TestBean;

import java.util.List;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/07 17:47
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class MRecylerViewAdapter extends RecyclerView.Adapter <MRecylerViewAdapter.MyHolder>{
    private List<TestBean> list;
    private int itmemLayoutId;

public MRecylerViewAdapter(List<TestBean> list,int itmemLayoutId){
    this.list=list;
    this.itmemLayoutId=itmemLayoutId;
}
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyHolder myHolder=new MyHolder(View.inflate(MyApplication.mApplicationContext,itmemLayoutId,null));
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.getTextView(R.id.mtextview).setText(list.get(position).getTitle());
        Glide.with(MyApplication.mApplicationContext).load(list.get(position).getImageurl()).into((ImageView) holder.getView(R.id.mimageview));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends ViewHolder{
        View view;
        SparseArray<View> views;
        public MyHolder(View view){
            super(view);
            this.view=view;
            views=new SparseArray<>();
        }
        public View getRootView(){
            return view;
        }
        public View getView(int viewId){
            if(views.get(viewId)==null){
               views.put(viewId, this.view.findViewById(viewId));
            }
            return views.get(viewId);
        }
        public TextView getTextView(int viewId){
            if(views.get(viewId)==null){
                views.put(viewId, this.view.findViewById(viewId));
            }
            return (TextView) views.get(viewId);
        }
    }
}
