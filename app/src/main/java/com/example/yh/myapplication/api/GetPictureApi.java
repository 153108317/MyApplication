package com.example.yh.myapplication.api;

import com.alibaba.fastjson.JSON;
import com.android.volley.VolleyError;
import com.example.yh.myapplication.interfaces.HttpCallBack;
import com.example.yh.myapplication.network.HttpTask;
import com.example.yh.myapplication.result.PictureResult;
import com.example.yh.myapplication.views.IView;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/11 16:13
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class GetPictureApi {
private static String mResult="{\n" +
        "  \"error\": false, \n" +
        "  \"results\": [\n" +
        "    {\n" +
        "      \"_id\": \"58f3980c421aa9544b773ff1\", \n" +
        "      \"createdAt\": \"2017-04-17T00:13:00.136Z\", \n" +
        "      \"desc\": \"4-17\", \n" +
        "      \"publishedAt\": \"2017-04-17T11:32:14.674Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-16-17934400_1738549946443321_2924146161843437568_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"daimajia\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58f0438f421aa9544825f873\", \n" +
        "      \"createdAt\": \"2017-04-14T11:35:43.995Z\", \n" +
        "      \"desc\": \"4-14\", \n" +
        "      \"publishedAt\": \"2017-04-14T11:46:48.47Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-14-17881962_1329090457138411_8289893708619317248_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"\\u4ee3\\u7801\\u5bb6\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58eef016421aa9544b773fd0\", \n" +
        "      \"createdAt\": \"2017-04-13T11:27:18.557Z\", \n" +
        "      \"desc\": \"4-13\", \n" +
        "      \"publishedAt\": \"2017-04-13T11:36:04.435Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-13-17882785_926451654163513_7725522121023029248_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"dmj\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58ed8242421aa9544b773fc1\", \n" +
        "      \"createdAt\": \"2017-04-12T09:26:26.434Z\", \n" +
        "      \"desc\": \"4-12\", \n" +
        "      \"publishedAt\": \"2017-04-12T12:12:18.213Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-12-17662441_1675934806042139_7236493360834281472_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"daimajia\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58ec30e4421aa9544ed88919\", \n" +
        "      \"createdAt\": \"2017-04-11T09:27:00.840Z\", \n" +
        "      \"desc\": \"4-11\", \n" +
        "      \"publishedAt\": \"2017-04-11T14:43:34.738Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-11-17881546_248332202297978_2420944671002853376_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"dmj\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58ea5f51421aa954511ebe51\", \n" +
        "      \"createdAt\": \"2017-04-10T00:20:33.996Z\", \n" +
        "      \"desc\": \"4-10\", \n" +
        "      \"publishedAt\": \"2017-04-10T12:11:14.794Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-09-17586558_426275167734768_6312107349515436032_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"dmj\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58e6dec3421aa90d6f211e4a\", \n" +
        "      \"createdAt\": \"2017-04-07T08:35:15.664Z\", \n" +
        "      \"desc\": \"4-7\", \n" +
        "      \"publishedAt\": \"2017-04-07T12:02:31.316Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-07-17817932_274034076387428_5240190736292380672_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"\\u5e26\\u9a6c\\u7532\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58e5bd9c421aa90d6f211e3f\", \n" +
        "      \"createdAt\": \"2017-04-06T12:01:32.576Z\", \n" +
        "      \"desc\": \"4-6\", \n" +
        "      \"publishedAt\": \"2017-04-06T12:06:10.17Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-06-17493825_1061197430652762_1457834104966873088_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"\\u4ee3\\u7801\\u5bb6\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58e3198e421aa90d6bc75ab4\", \n" +
        "      \"createdAt\": \"2017-04-04T11:57:02.111Z\", \n" +
        "      \"desc\": \"4-4\", \n" +
        "      \"publishedAt\": \"2017-04-05T11:50:18.748Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-04-04-17438270_1418311001574160_8728796670000627712_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"dmj\"\n" +
        "    }, \n" +
        "    {\n" +
        "      \"_id\": \"58ddcb2b421aa969f51a911e\", \n" +
        "      \"createdAt\": \"2017-03-31T11:21:15.303Z\", \n" +
        "      \"desc\": \"3-31\", \n" +
        "      \"publishedAt\": \"2017-03-31T11:26:54.330Z\", \n" +
        "      \"source\": \"chrome\", \n" +
        "      \"type\": \"\\u798f\\u5229\", \n" +
        "      \"url\": \"http://7xi8d6.com1.z0.glb.clouddn.com/2017-03-31-17662615_1819763634937161_2829588299293655040_n.jpg\", \n" +
        "      \"used\": true, \n" +
        "      \"who\": \"dmj\"\n" +
        "    }\n" +
        "  ]\n" +
        "}";
    public static void getPictureBeans(String url,int type, final IView iView){
        HttpTask task=new HttpTask(PictureResult.class);
        task.setHttpCallBack(new HttpCallBack<PictureResult>() {

            @Override
            public void onSuccess(PictureResult result, int typeId) {
                PictureResult  mresult=JSON.parseObject(mResult,PictureResult.class);

                result=JSON.parseObject(mResult,PictureResult.class);
                result.getResults().addAll(mresult.getResults());
                if(iView!=null)
                    iView.getBean(result);
            }

            @Override
            public void onError(VolleyError volleyError) {

            }
        });
        task.getJSONObjectResult(url);
    }

}
