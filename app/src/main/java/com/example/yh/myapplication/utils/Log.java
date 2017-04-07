package com.example.yh.myapplication.utils;

/**
 * Created by yh on 2017/4/6.
 */

public class Log {
    public static String TAG="tag";
    private static boolean ISLOG=true;
    public static void e(String msg){
        if(!ISLOG)return;
        StackTraceElement ste=new Throwable().getStackTrace()[1];
        android.util.Log.e(TAG,ste.getClassName()+ste.getLineNumber()+"\n"+msg);
    }    public static void d(String msg){
        if(!ISLOG)return;
        StackTraceElement ste=new Throwable().getStackTrace()[1];
        android.util.Log.d(TAG,ste.getClassName()+ste.getLineNumber()+"\n"+msg);
    }    public static void i(String msg){
        if(!ISLOG)return;
        StackTraceElement ste=new Throwable().getStackTrace()[1];
        android.util.Log.i(TAG,ste.getClassName()+ste.getLineNumber()+"\n"+msg);
    }    public static void w(String msg){
        if(!ISLOG)return;
        StackTraceElement ste=new Throwable().getStackTrace()[1];
        android.util.Log.w(TAG,ste.getClassName()+ste.getLineNumber()+"\n"+msg);
    }
}
