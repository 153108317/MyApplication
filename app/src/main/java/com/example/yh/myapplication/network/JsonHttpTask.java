package com.example.yh.myapplication.network;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.yh.myapplication.MyApplication;

import org.json.JSONObject;

/**
 * Created by yh on 2017/3/31.
 */

public class JsonHttpTask {
    private void getJSONObjectResult(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(MyApplication.mApplicationContext);
   JsonObjectRequest request=new JsonObjectRequest(url,null,new Response.Listener<JSONObject>(){
       @Override
       public void onResponse(JSONObject jsonObject) {

       }
   },new Response.ErrorListener(){
       @Override
       public void onErrorResponse(VolleyError volleyError) {

       }
   });
        requestQueue.add(request);

    }
}
