package com.example.yh.myapplication.result;

import com.example.yh.myapplication.base.BasicResult;
import com.example.yh.myapplication.entities.PictureBean;

import java.util.List;

/**
 * Fixme
 * Author: YH
 * Date: 2017/04/11 16:07
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class PictureResult extends BasicResult {
    private List<PictureBean> results;

    public List<PictureBean> getResults() {
        return results;
    }

    public void setResults(List<PictureBean> results) {
        this.results = results;
    }
}
