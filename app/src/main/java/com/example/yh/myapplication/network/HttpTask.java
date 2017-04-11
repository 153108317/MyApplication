package com.example.yh.myapplication.network;


import com.alibaba.fastjson.JSON;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.yh.myapplication.MyApplication;
import com.example.yh.myapplication.base.BasicResult;
import com.example.yh.myapplication.interfaces.HttpCallBack;
import com.example.yh.myapplication.utils.Log;

import org.json.JSONObject;

/**
 * Created by yh on 2017/3/31.
 */

public class HttpTask<T extends BasicResult> {
    Class<T> clazz;
    private RequestQueue mRequestQueue;
    private HttpCallBack mHttpCallBack;

    public HttpTask(Class<T> clazz) {
        this(null, clazz);
    }

    public HttpTask(HttpCallBack callBack, Class<T> clazz) {
        this.mHttpCallBack = callBack;
        this.clazz = clazz;
    }

    public void setHttpCallBack(HttpCallBack mHttpCallBack) {
        this.mHttpCallBack = mHttpCallBack;
    }

    public void getStringRequest(String url) {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(MyApplication.mApplicationContext);

        }
        //  url += "?lng=126.5&lat=26.5&deviceType=3";
        Log.e("url:" + url);
        StringRequest mStringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                if (mHttpCallBack != null) {


//                    T tt = JSON.parseObject(s, clazz);
//
//                    mHttpCallBack.onSuccess(tt);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (mHttpCallBack != null) {
                    mHttpCallBack.onError(volleyError);
                }
            }
        });

        mRequestQueue.add(mStringRequest);
    }

    public void getJSONObjectResult(String url) {
        Log.e("url"+url);
        RequestQueue requestQueue = Volley.newRequestQueue(MyApplication.mApplicationContext);
        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {

                Log.e(jsonObject.toString());
                if (mHttpCallBack != null) {
                    T tt = JSON.parseObject(jsonObject.toString(), clazz);
                    mHttpCallBack.onSuccess(tt, 0);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("" + volleyError.getMessage());
                if (mHttpCallBack != null) {
                    mHttpCallBack.onError(volleyError);
                }
            }
        });
        requestQueue.add(request);

    }


}
