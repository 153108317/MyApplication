package com.example.yh.myapplication.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.base.BasicFragment;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/07 11:21
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class PictureFragment extends BasicFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_picture,container,false);
        return view;
    }
}
