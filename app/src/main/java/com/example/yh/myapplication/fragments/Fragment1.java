package com.example.yh.myapplication.fragments;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.activities.ItemRemoveRecyclerviewActivity;
import com.example.yh.myapplication.adapters.Picture1RecylerViewAdapter;
import com.example.yh.myapplication.api.GetPictureApi;
import com.example.yh.myapplication.base.BasicFragment;
import com.example.yh.myapplication.entities.PictureBean;
import com.example.yh.myapplication.network.HttpUrls;
import com.example.yh.myapplication.result.PictureResult;
import com.example.yh.myapplication.utils.PtrMDHeader;
import com.example.yh.myapplication.views.IView;
import com.example.yh.myapplication.widget.RemoveRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/17 17:11
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class Fragment1 extends BasicFragment implements IView<PictureResult> {
    @BindView(R.id.store_house_ptr_image_content)
    View store_house_ptr_image_content;
    @BindView(R.id.lay_ptr_frame)
    PtrFrameLayout lay_ptr_frame;
    @BindView(R.id.mrecylerview)
    RemoveRecyclerView mRecyclerView;
    private List<PictureBean> mList;
    private Picture1RecylerViewAdapter mPicture1RecylerViewAdapter;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment1;
    }

    private Handler mHandler = new Handler() {
    };

    @Override
    protected void initView() {
        mList=new ArrayList<>();
        mPicture1RecylerViewAdapter=new Picture1RecylerViewAdapter(mList,R.layout.reycelerview_picture1_item);
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mPicture1RecylerViewAdapter);
      //  addData();
        final PtrMDHeader header = new PtrMDHeader(getContext());
        lay_ptr_frame.setHeaderView(header);
        lay_ptr_frame.addPtrUIHandler(header);
        lay_ptr_frame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, store_house_ptr_image_content, header);
            }

            @Override
            public void onRefreshBegin(final PtrFrameLayout frame) {
                // 模仿延时3000毫秒
                GetPictureApi.getPictureBeans(HttpUrls.PICTURESURL+1,0,Fragment1.this);
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        frame.refreshComplete();
                    }
                }, 3000);
            }
        });
    }

    private void addData(){
        GetPictureApi.getPictureBeans(HttpUrls.PICTURESURL+1,0,this);
    }
@OnClick(R.id.fragment1)public void mclick(View view){
    switch (view.getId()){
        case R.id.fragment1:
            getBasicActivity().openActivity(ItemRemoveRecyclerviewActivity.class);
            break;
    }
}
    @Override
    public void getBean(PictureResult v) {
        if(v.getResults()!=null &&v.getResults().size()>0) {
            mList.addAll(v.getResults());
            mPicture1RecylerViewAdapter.notifyDataSetChanged();

        }
       // frame.refreshComplete();
    }
}
