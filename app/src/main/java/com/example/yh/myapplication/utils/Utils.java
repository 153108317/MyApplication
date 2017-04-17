package com.example.yh.myapplication.utils;

import android.widget.Toast;

import com.example.yh.myapplication.MyApplication;

/**
 * Fixme
 * Author: PengHong
 * Date: 2017/04/17 15:07
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class Utils {
    public static void Toast(String content){
        Toast.makeText(MyApplication.mApplicationContext,content,Toast.LENGTH_SHORT).show();
    } public static void Toast(int  stringId){
        Toast.makeText(MyApplication.mApplicationContext,stringId,Toast.LENGTH_SHORT).show();
    }
}
