package com.example.yh.myapplication.interfaces;

import android.graphics.Bitmap;

import com.android.volley.VolleyError;

/**
 * Created by yh on 2017/4/1.
 */

public interface ImageCallBack {
    void onSuccess(Bitmap bitmap);
    void onError(VolleyError volleyError);
}
