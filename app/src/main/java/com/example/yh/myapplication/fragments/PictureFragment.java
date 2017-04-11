package com.example.yh.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.adapters.MyRecylerViewAdapter;
import com.example.yh.myapplication.base.BasicFragment;
import com.example.yh.myapplication.entities.TestBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/07 11:21
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class PictureFragment extends BasicFragment {
    @BindView(R.id.mrecylerview)RecyclerView mRecyclerView;
    private MyRecylerViewAdapter mMyRecylerViewAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_picture,container,false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       List<TestBean> //list=((TestBean)getArguments().getSerializable("test")).getList();
        list=new ArrayList<>();
         String imageUrl="http://www.baidu.com/img/bdlogo.png";
        String url="http://gank.io/api/data/福利/10/1";
        for (int i=0;i<10;i++){
            TestBean testBean=new TestBean();
            testBean.setTitle("title"+i);
            testBean.setImageurl(imageUrl);
            list.add(testBean);
        }
    mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mRecyclerView.setAdapter(new MRecylerViewAdapter(list,R.layout.listview_item));
        mMyRecylerViewAdapter=new MyRecylerViewAdapter(list,R.layout.listview_item);
        mRecyclerView.setAdapter(mMyRecylerViewAdapter);
    }
}
