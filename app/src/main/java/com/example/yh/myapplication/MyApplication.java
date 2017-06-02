package com.example.yh.myapplication;

import android.app.Application;
import android.content.Context;

import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by yh on 2017/3/29.
 */

public class MyApplication extends Application {
    public static Context mApplicationContext;
    //public static RefWatcher refWatcher = null;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext= getApplicationContext();
        ZXingLibrary.initDisplayOpinion(MyApplication.mApplicationContext);
     //   refWatcher = LeakCanary.install(this);
    }
}
