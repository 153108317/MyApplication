package com.example.yh.myapplication.network.retrofithttptest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.yh.myapplication.utils.Log;
import com.example.yh.myapplication.views.IView;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/09 23:04
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class RetrofitHttpTask<T> {
    private Class<T> clazz;



    public RetrofitHttpTask(Class<T> t) {
        clazz = t;

    }

    public void getData(String url, final IView iView) {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitI retrofitI = retrofit.create(RetrofitI.class);

        Call<JSONObject> call = retrofitI.getdata("/data/cityinfo/101010100.html");

        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                Log.e(response.body().toJSONString());
                if (iView != null) {
                    T t = JSON.parseObject(response.body().toString(), clazz);
                    iView.getBean(t);
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {

            }
        });
    }

    public void post(String url,String address, Map<String,String>param,final IView iView) {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitI retrofitI = retrofit.create(RetrofitI.class);
        if(param==null){
            param=new HashMap<>();
        }

        param   .put("app", "APP.Buyer.Android");
        param   .put("appVersion", "V2.3.6");
        param     .put("appTerminal", "APP.Buyer.Android");
        Call<JSONObject> call = retrofitI.postData("",param);

        call.enqueue(new Callback<JSONObject>() {
            @Override
            public void onResponse(Call<JSONObject> call, Response<JSONObject> response) {
                Log.e(response.body().toJSONString());
                if (iView != null) {
                    T t = JSON.parseObject(response.body().toString(), clazz);
                    iView.getBean(t);
                }
            }

            @Override
            public void onFailure(Call<JSONObject> call, Throwable t) {

            }
        });
    }

    public Retrofit getData(String url) {
        return new Retrofit.Builder()
                .baseUrl(url).addConverterFactory(GsonConverterFactory.create())
                .build();


    }


}
