package com.example.yh.myapplication.presenter;

import android.graphics.Bitmap;
import android.util.Log;

import com.android.volley.VolleyError;
import com.example.yh.myapplication.interfaces.HttpCallBack;
import com.example.yh.myapplication.interfaces.ImageCallBack;
import com.example.yh.myapplication.network.HttpTask;
import com.example.yh.myapplication.network.ImageLoad;
import com.example.yh.myapplication.result.TestBean;
import com.example.yh.myapplication.views.IView;

import java.util.ArrayList;

/**
 * Created by yh on 2017/3/31.
 */

public class PresenterTestBean {
    private IView iView;
    private IView imageView;

    public PresenterTestBean(IView iview){
        this.iView=iview;
    }
    public void setImageView(IView imageView){
        this.imageView=imageView;
    }
    public void getData(String url){
        HttpTask<TestBean> httpTask=new HttpTask<TestBean>(TestBean.class);
        httpTask.setHttpCallBack(new HttpCallBack<TestBean>() {
            @Override
            public void onSuccess(TestBean result) {

                if(iView!=null){
                    result.setList(new ArrayList<TestBean>());
                    for (int i=0;i<10;i++){
                        TestBean tb=new TestBean();
                        tb.setTitle("title"+i);
                        result.getList().add(tb );
                    }

                    iView.getBean(result);
                }
            }

            @Override
            public void onSuccess(TestBean result, int typeId) {

            }

            @Override
            public void onError(VolleyError volleyError) {

            }
        });
        httpTask.getJSONObjectResult(url);
    }
    public void getBitmap(String url){
        Log.e("tag","url"+url);
        ImageLoad imageLoad=new ImageLoad(new ImageCallBack() {
            @Override
            public void onSuccess(Bitmap bitmap) {
                Log.e("tag","bitmap"+bitmap);
                if(imageView!=null){
                    imageView.getBean(bitmap);
                }
            }

            @Override
            public void onError(VolleyError volleyError) {
                Log.e("tag","volleyError.getMessage()"+volleyError.getMessage());
            }
        });
        imageLoad.getImage(url);
    }
}
