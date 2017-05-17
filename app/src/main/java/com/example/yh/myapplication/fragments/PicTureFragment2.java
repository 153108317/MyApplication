package com.example.yh.myapplication.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.adapters.Picture1RecylerViewAdapter;
import com.example.yh.myapplication.api.GetPictureApi;
import com.example.yh.myapplication.base.BasicFragment;
import com.example.yh.myapplication.entities.PictureBean;
import com.example.yh.myapplication.network.HttpUrls;
import com.example.yh.myapplication.result.PictureResult;
import com.example.yh.myapplication.views.IView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Fixme
 * Author: yh
 * Date: 2017/04/17 15:29
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class PicTureFragment2 extends BasicFragment implements IView<PictureResult>,SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.mrecylerview)
    RecyclerView mRecyclerView;
    /**/
    @BindView(R.id.swiperefreshLayout)
    SwipeRefreshLayout mSwiperefreshLayout;
    private Picture1RecylerViewAdapter mPicture1RecylerViewAdapter;
    private List<PictureBean> mList;
    private int orientation= LinearLayoutManager.HORIZONTAL;

    @Override
    protected int getLayoutId() {
        return R.layout.fatgment_picture1;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mList=new ArrayList<>();
        mPicture1RecylerViewAdapter=new Picture1RecylerViewAdapter(mList,R.layout.reycelerview_picture1_item);
       // LinearLayoutManager manager=new LinearLayoutManager(getActivity());
       // manager.setOrientation(LinearLayoutManager.VERTICAL);
        StaggeredGridLayoutManager manager=
                new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mPicture1RecylerViewAdapter);
        mSwiperefreshLayout.setOnRefreshListener(this);
       Resources res= getResources();
        mSwiperefreshLayout.setColorSchemeColors(res.getColor(R.color.colorAccent),
                res.getColor(R.color.colorPrimaryDark),
                res.getColor(R.color.colorgray),
                res.getColor(R.color.colorPrimary));
        GetPictureApi.getPictureBeans(HttpUrls.PICTURESURL+1,0,this);
    }

    @Override
    public void getBean(PictureResult v) {
        if(v.getResults()!=null &&v.getResults().size()>0) {
            mList.addAll(v.getResults());
            mPicture1RecylerViewAdapter.notifyDataSetChanged();
            //  mPicture1RecylerViewAdapter.notify();
            mSwiperefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void onRefresh() {
        GetPictureApi.getPictureBeans(HttpUrls.PICTURESURL+1,0,this);
    }
}

