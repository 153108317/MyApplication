package com.example.yh.myapplication.utils;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/13 23:24
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class NDKJniUtils {
    static {
        System.loadLibrary("mndklib");
    }
    public native String getCLanguageString();
}
