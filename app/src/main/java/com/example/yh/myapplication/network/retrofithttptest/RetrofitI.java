package com.example.yh.myapplication.network.retrofithttptest;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.QueryMap;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/09 23:15
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public interface RetrofitI<T> {
    @Headers({"User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64)",
    "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
    "Accept-Language: zh-CN,zh;q=0.8",
            "Content-Type: application/json"
    })
    @GET("/data/cityinfo/101010100.html")
    Call<T> getWeatherinfo();
    @GET("{myaddress}")
    Call<JSONObject> getdata(@Path("myaddress")String myaddress);

    @Headers({"User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64)",
            "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
            "Accept-Language: zh-CN,zh;q=0.8"
            ,
            "Content-Type: application/json"
    })
    @POST("{myaddress}")
    Call<JSONObject> postData(@Path("myaddress")String myaddress, @QueryMap Map<String ,String> param);

}
