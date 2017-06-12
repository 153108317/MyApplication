package com.example.yh.myapplication;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.yh.myapplication.db.DBConstants;
import com.example.yh.myapplication.db.DaoMaster;
import com.example.yh.myapplication.db.DaoSession;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

/**
 * Created by yh on 2017/3/29.
 */

public class MyApplication extends Application {
    public static Context mApplicationContext;
    private static DaoSession sDaoSession;
    //public static RefWatcher refWatcher = null;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = getApplicationContext();
        ZXingLibrary.initDisplayOpinion(MyApplication.mApplicationContext);
        //   refWatcher = LeakCanary.install(this);
        setupDataDB();
    }

    private void setupDataDB() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, DBConstants.DB_NAME);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        sDaoSession= daoMaster.newSession();

    }
    public static DaoSession getDaoSession() {
        return sDaoSession;
    }
}
