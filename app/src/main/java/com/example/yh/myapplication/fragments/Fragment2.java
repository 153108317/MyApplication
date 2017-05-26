package com.example.yh.myapplication.fragments;

import android.view.View;
import android.widget.LinearLayout;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.activities.ScrollerActivity;
import com.example.yh.myapplication.base.BasicFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/17 17:12
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class Fragment2 extends BasicFragment {
    @BindView(R.id.layout)
    LinearLayout layout;
    @Override
    protected int getLayoutId() {
        return R.layout.fragment2;
    }

    @Override
    protected void initView() {

    }
    @OnClick({R.id.scroll_to_btn,R.id.scroll_by_btn}  )public void mclick(View view){
        switch (view.getId()){
            case R.id.scroll_to_btn:
                getBasicActivity().openActivity(ScrollerActivity.class);
                layout.scrollTo(-60, -100);
                break;
            case R.id.scroll_by_btn:
                layout.scrollBy(-60, -100);
                break;
        }
    }
}
