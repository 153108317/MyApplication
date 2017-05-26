package com.example.yh.myapplication.activities;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.adapters.RemoveRecyclerViewAdapter;
import com.example.yh.myapplication.api.GetPictureApi;
import com.example.yh.myapplication.base.BasicActivity;
import com.example.yh.myapplication.entities.PictureBean;
import com.example.yh.myapplication.interfaces.OnItemClickListener;
import com.example.yh.myapplication.network.HttpUrls;
import com.example.yh.myapplication.result.PictureResult;
import com.example.yh.myapplication.utils.Log;
import com.example.yh.myapplication.views.IView;
import com.example.yh.myapplication.widget.ItemRemoveRecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/26 11:15
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class ItemRemoveRecyclerviewActivity  extends BasicActivity implements IView<PictureResult>, OnItemClickListener<String>{

    @BindView(R.id.mrecylerview)
    ItemRemoveRecyclerView mRecyclerView;
    private ArrayList<PictureBean> mList;
    private RemoveRecyclerViewAdapter mRemoveRecyclerViewAdapter;
    private Handler mHandler = new Handler() {
    };

    @Override
    protected int getLayoutId() {
        return R.layout.mrecyclerview;
    }

    @Override
    protected void initView() {
        mList=new ArrayList<>();
        mRemoveRecyclerViewAdapter=new RemoveRecyclerViewAdapter(mList,R.layout.reycelerview_picture1_item);

        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setOnItemClickListener(this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mRemoveRecyclerViewAdapter);
        addDataAgain();

    }

    @Override
    protected void addDataAgain() {
        GetPictureApi.getPictureBeans(HttpUrls.PICTURESURL+1,0,this);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        mRemoveRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(View view, int position,String str) {

        Log.e("positon"+position);
    }

    @Override
    public void onDeleteClick(int position,String str) {
        Log.e("positon"+position);
        mRemoveRecyclerViewAdapter.delete(position);
    }


    @Override
    public void getBean(PictureResult v) {
        if(v.getResults()!=null &&v.getResults().size()>0) {
            mList.addAll(v.getResults());
            mRemoveRecyclerViewAdapter.notifyDataSetChanged();

        }
    }
}
