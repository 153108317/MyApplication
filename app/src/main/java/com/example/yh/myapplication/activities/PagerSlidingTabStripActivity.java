package com.example.yh.myapplication.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.adapters.MyPagerAdapter;
import com.example.yh.myapplication.base.BasicActivity;
import com.example.yh.myapplication.fragments.Fragment1;
import com.example.yh.myapplication.fragments.Fragment2;
import com.example.yh.myapplication.fragments.Fragment3;
import com.example.yh.myapplication.widget.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/17 14:15
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class PagerSlidingTabStripActivity extends BasicActivity {
    private List<Fragment> mFragments;
    private List<String> mStrings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pragerslidingtabstrip;
    }

    private MyPagerAdapter mMyPagerAdapter;
    private  Fragment creat(Supplier<Fragment> supplier){
        return  supplier.get();
    }
    @Override
    protected void initView() {
//        mFragments = new ArrayList<>();
//        mFragments.add(new Fragment1());
//        mFragments.add(new Fragment2());
//        mFragments.add(new Fragment3());
        mFragments= Arrays.asList(creat(Fragment1::new),creat(Fragment2::new),creat(Fragment3::new));
        mStrings = new ArrayList<>();
        mStrings.add("fragment1");
        mStrings.add("fragment2");
        mStrings.add("fragment3");
// Initialize the ViewPager and set an adapter
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        mMyPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), mStrings, mFragments);
        pager.setAdapter(mMyPagerAdapter);

// Bind the tabs to the ViewPager
        PagerSlidingTabStrip tabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        tabs.setViewPager(pager);
        tabs.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mMyPagerAdapter.getItem(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void addDataAgain() {

    }
}
