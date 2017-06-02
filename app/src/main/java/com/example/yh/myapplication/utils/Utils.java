package com.example.yh.myapplication.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.example.yh.myapplication.MyApplication;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Fixme
 * Author: PengHong
 * Date: 2017/04/17 15:07
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class Utils {
    public static void Toast(String content) {
        Toast.makeText(MyApplication.mApplicationContext, content, Toast.LENGTH_SHORT).show();
    }

    public static void Toast(int stringId) {
        Toast.makeText(MyApplication.mApplicationContext, stringId, Toast.LENGTH_SHORT).show();
    }

    public static boolean isEmpty(String str) {
        return str == null || str.equals("") || str.equals("null");
    }

    public static Bitmap getBitmap(String url) {

        Bitmap bitmap = null;
        try {
            URL iconUrl = new URL(url);
            URLConnection urlConnection = iconUrl.openConnection();
            HttpURLConnection httpURLConnection= (HttpURLConnection) urlConnection;
            int length=httpURLConnection.getContentLength();
            urlConnection.connect();
            InputStream inputStream=urlConnection.getInputStream();
            BufferedInputStream bis=new BufferedInputStream(inputStream,length);
            bitmap=BitmapFactory.decodeStream(bis);
            bis.close();
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
