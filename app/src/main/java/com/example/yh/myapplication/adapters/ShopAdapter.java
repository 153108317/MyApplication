package com.example.yh.myapplication.adapters;

import com.example.yh.myapplication.R;
import com.example.yh.myapplication.base.BasicRecylerViewAdapter;
import com.example.yh.myapplication.base.RecylerViewHolder;
import com.example.yh.myapplication.db.Shop;

import java.util.List;

/**
 * Fixme
 * Author: YH
 * Date: 2017/06/12 15:22
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */

public class ShopAdapter extends BasicRecylerViewAdapter<Shop> {
    public ShopAdapter(List<Shop> list, int itmemLayoutId) {
        super(list, itmemLayoutId);
    }

    @Override
    protected void onConvert(RecylerViewHolder holder, int position, Shop shop) {
        holder.setImage(R.id.iv_shop,R.mipmap.ic_launcher);
        holder.setText(R.id.tv_name,shop.getName());
        holder.setText(R.id.tv_price,shop.getPrice() + "");
        holder.setText(R.id.tv_price_discount,"dd");//setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        holder.setText(R.id.tv_sell_num,"已售" + shop.getSell_num() + "件");
    }
}
