package com.example.yh.myapplication.base;

import java.io.Serializable;

/**
 * Created by yh on 2017/3/31.
 */

public class BasicResult implements Serializable{
    private int status;
    private String data;
    private String msg;
    private boolean error ;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
