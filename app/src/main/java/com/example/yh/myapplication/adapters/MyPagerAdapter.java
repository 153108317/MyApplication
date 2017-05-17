package com.example.yh.myapplication.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/17 17:54
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    private List<String > mStringList;
    private List<Fragment> mFragments;
    public MyPagerAdapter(FragmentManager fm,List<String > mStringList,List<Fragment> mFragments) {

        super(fm);
        this.mStringList=mStringList;
        this.mFragments=mFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mStringList.size();
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mStringList.get(position);
    }
}
