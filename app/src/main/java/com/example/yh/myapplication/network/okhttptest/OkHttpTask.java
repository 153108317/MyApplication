package com.example.yh.myapplication.network.okhttptest;

import com.alibaba.fastjson.JSON;
import com.example.yh.myapplication.MyApplication;
import com.example.yh.myapplication.base.BasicResult;
import com.example.yh.myapplication.interfaces.HttpCallBack;
import com.example.yh.myapplication.utils.Log;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/08 17:23
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class OkHttpTask<T extends BasicResult> {
    private Class<T> clazz;
    private HttpCallBack mHttpCallBack;

    public OkHttpTask(Class<T> t) {
        this(null, t);
    }

    public OkHttpTask(HttpCallBack callBack, Class<T> clazz) {
        mHttpCallBack = callBack;
        this.clazz = clazz;
    }


    public void setHttpCallBack(HttpCallBack httpCallBack) {
        mHttpCallBack = httpCallBack;
    }

    public void getTask(String url, int type) {
        getTask(url, null, type);
    }

    public void getTask(String url, RequestBody requestBody, final int type) {
        File sdcache = MyApplication.mApplicationContext.getExternalCacheDir();
        int cacheSize = 10 * 1024 * 1024;
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .cache(new Cache(sdcache.getAbsoluteFile(), cacheSize));
      //  OkHttpClient client = new OkHttpClient();
        OkHttpClient client = builder.build();



        Request.Builder rbuilder = new Request.Builder().url(url);
        if (requestBody != null)
            rbuilder.post(requestBody);
        Request request = rbuilder.build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                Log.e(str);

                T t = JSON.parseObject(str, clazz);
                if (mHttpCallBack != null) {
                    if (t != null) {
                        mHttpCallBack.onSuccess(t, type);
                    }
                }
            }
        });
    }
    private static final MediaType MEDIA_TYPE_PNG = MediaType.parse("image/png");

    OkHttpClient client;
    private void sendMultipart(){
        client = new OkHttpClient();
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("title", "wangshu")
                .addFormDataPart("image", "wangshu.jpg",
                        RequestBody.create(MEDIA_TYPE_PNG, new File("/sdcard/wangshu.jpg")))
                .build();
        Request request = new Request.Builder()
                .header("Authorization", "Client-ID " + "...")
                .url("https://api.imgur.com/3/image")
                .post(requestBody)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e( response.body().string());
            }
        });
    }
}
