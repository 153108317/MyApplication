package com.example.yh.myapplication.network.retrofithttptest;

import java.io.Serializable;

/**
 * Fixme
 * Author: YH
 * Date: 2017/05/10 18:08
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class BasicModle<T> implements Serializable {
    private T data;
    private int status;
    private String msg;
    private boolean success;
    private boolean login;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }
}
