package com.example.yh.myapplication.network;

import android.graphics.Bitmap;
import android.view.View;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.example.yh.myapplication.MyApplication;
import com.example.yh.myapplication.interfaces.ImageCallBack;
import com.example.yh.myapplication.utils.Log;

/**
 * Created by yh on 2017/4/1.
 */

public class ImageLoad {
    private RequestQueue requestQueue;
    private ImageCallBack imageCallBack;

    public ImageLoad(ImageCallBack imageCallBack) {
        this.imageCallBack = imageCallBack;
    }

    public void getImage(String url) {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(MyApplication.mApplicationContext);
        }

        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {

            @Override
            public void onResponse(Bitmap bitmap) {
                Log.e( "bitmap" + bitmap);
                if (imageCallBack != null) {
                    imageCallBack.onSuccess(bitmap);
                }
            }
        }, 100, 100, Bitmap.Config.RGB_565, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("volleyError" + volleyError);
                if (imageCallBack != null) imageCallBack.onError(volleyError);
            }
        });
        requestQueue.add(imageRequest);
    }
}
