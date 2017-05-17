package com.example.yh.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.activities.DetailActivity;
import com.example.yh.myapplication.adapters.MyRecylerViewAdapter;
import com.example.yh.myapplication.base.BasicFragment;
import com.example.yh.myapplication.entities.TestBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/07 11:21
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class PictureFragment extends BasicFragment {
    @BindView(R.id.mrecylerview)
    RecyclerView mRecyclerView;
    @BindView(R.id.tv)TextView tv;
    private MyRecylerViewAdapter mMyRecylerViewAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_picture;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        List<TestBean> //list=((TestBean)getArguments().getSerializable("test")).getList();

                list = new ArrayList<>();
        String imageUrl = "http://www.baidu.com/img/bdlogo.png";
        String url = "http://gank.io/api/data/福利/10/1";
        for (int i = 0; i < 25; i++) {
            TestBean testBean = new TestBean();
            testBean.setTitle("title" + i);
            testBean.setImageurl(imageUrl);
            list.add(testBean);
        }
        // mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //  GridLayoutManager mLayoutManager=new GridLayoutManager(getActivity(),3,GridLayoutManager.VERTICAL,false);//设置为一个3列的纵向网格布局
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false));
        mMyRecylerViewAdapter = new MyRecylerViewAdapter(list, R.layout.listview_item);
        mRecyclerView.setAdapter(mMyRecylerViewAdapter);

    }
    @OnClick({R.id.tv})public void mClick(View view){
        switch (view.getId()){
            case R.id.tv:
                getBasicActivity().openActivity(DetailActivity.class,null);
                getActivity().finish();
                break;
        }
    }
}
