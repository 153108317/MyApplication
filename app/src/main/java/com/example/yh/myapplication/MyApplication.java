package com.example.yh.myapplication;

import android.app.Application;
import android.content.Context;

/**
 * Created by yh on 2017/3/29.
 */

public class MyApplication extends Application {
    public static Context mApplicationContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext= getApplicationContext();
    }
}
