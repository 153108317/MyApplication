package com.example.yh.myapplication.api;

import android.content.Context;

import com.android.volley.VolleyError;
import com.example.yh.myapplication.entities.TestBean;
import com.example.yh.myapplication.entities.UserBean;
import com.example.yh.myapplication.interfaces.HttpCallBack;
import com.example.yh.myapplication.network.okhttptest.OkHttpTask;
import com.example.yh.myapplication.views.IView;

import okhttp3.RequestBody;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/08 19:44
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class OkHttpGetDataApi {
   private  Context mContext;
    public OkHttpGetDataApi(Context context){
        mContext=context.getApplicationContext();
    }
    public void getData(String url, int type, final IView<TestBean> iView){
        OkHttpTask okHttpTask=new OkHttpTask(TestBean.class);
        okHttpTask.setHttpCallBack(new HttpCallBack<TestBean>() {
            @Override
            public void onSuccess(TestBean result, int typeId) {
                if(iView!=null){
                    iView.getBean(result);
                }
            }

            @Override
            public void onError(VolleyError volleyError) {

            }
        });
        okHttpTask.getTask(url,type);

    }
public void getData(String url, RequestBody requestBody, int type, final IView<UserBean> iView){
        OkHttpTask okHttpTask=new OkHttpTask(UserBean.class);
        okHttpTask.setHttpCallBack(new HttpCallBack<UserBean>() {
            @Override
            public void onSuccess(UserBean result, int typeId) {
                if(iView!=null){
                    iView.getBean(result);
                }
            }

            @Override
            public void onError(VolleyError volleyError) {

            }
        });
        okHttpTask.getTask(url,requestBody,0);

    }

}
