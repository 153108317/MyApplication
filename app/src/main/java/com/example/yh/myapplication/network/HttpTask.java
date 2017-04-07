package com.example.yh.myapplication.network;

import android.graphics.Bitmap;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.yh.myapplication.MyApplication;
import com.example.yh.myapplication.base.BasicResult;
import com.example.yh.myapplication.interfaces.HttpCallBack;
import com.example.yh.myapplication.result.TestBean;

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
        this.mHttpCallBack = mHttpCallBack;
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
        Log.e("tag", "url:" + url);
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
    public  void getJSONObjectResult(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(MyApplication.mApplicationContext);
        JsonObjectRequest request=new JsonObjectRequest(url,null,new Response.Listener<JSONObject>(){
            @Override
            public void onResponse(JSONObject jsonObject) {
                if (mHttpCallBack != null) {
                T tt=JSON.parseObject(jsonObject.toString(),clazz);
                mHttpCallBack.onSuccess(tt);
                }
            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if(mHttpCallBack!=null)
                {
                    mHttpCallBack.onError(volleyError);
                }
            }
        });
        requestQueue.add(request);

    }


}
