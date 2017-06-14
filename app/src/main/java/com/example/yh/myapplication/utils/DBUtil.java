package com.example.yh.myapplication.utils;


import com.example.yh.myapplication.MyApplication;

import org.greenrobot.greendao.AbstractDao;

import static com.example.yh.myapplication.MyApplication.getDaoSession;

/**
 * 数据查询
 * Author: YH
 * Date: 2017/06/14 10:29
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class DBUtil<T, K> {
    private Class<T> mTClass;
    private Class<K> k;

    public DBUtil(Class<T> mTClass, Class<K> k) {
        this.mTClass = mTClass;
        this.k=k;
    }

    /**
     * 插入
     */
    public void insert(T t) {
        getDaoSession().insert(t);
    }

    /**
     * 插入或替换
     */
    private void insertOrReplace(T t) {
        getDaoSession().insertOrReplace(t);
    }

    /**
     * 删除 @param id
     */
    public void deleteByKey(K id) {
        AbstractDao<T, K> dao=( AbstractDao<T, K>) MyApplication.getDaoSession().getDao(mTClass);
        dao.deleteByKey(id);
       // AppProfile.getDaoSession().getFashionAllBeanDao().deleteByKey(id);
    }

    /**
     * 删除
     */
    public void delete(T t) {
        getDaoSession().delete(t);
        // AppProfile.getDaoSession().getFashionAllBeanDao().delete(fashionAllBean);
    }

    /**
     * 查询所有
     */
    public void loadAll() {
        getDaoSession().loadAll(mTClass);
        // AppProfile.getDaoSession().getFashionAllBeanDao().loadAll();
    }
    public T load(K k){
        return getDaoSession().load(mTClass,k);
    }
}
