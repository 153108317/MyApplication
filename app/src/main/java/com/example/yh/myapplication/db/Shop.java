package com.example.yh.myapplication.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Fixme
 * Author: YH
 * Date: 2017/06/12 14:00
 * Copyright (c) 2016 d2cmall. All rights reserved.
 */
/**
 *
 *
 *
 * Bean 对象注释的解释
 *
 * @Entity：告诉GreenDao该对象为实体，只有被@Entity注释的Bean类才能被dao类操作
 @Id：对象的Id，使用Long类型作为EntityId，否则会报错。(autoincrement = true)表示主键会自增，如果false就会使用旧值
 @Property：可以自定义字段名，注意外键不能使用该属性
 @NotNull：属性不能为空
 @Transient：使用该注释的属性不会被存入数据库的字段中
 @Unique：该属性值必须在数据库中是唯一值
 @Generated：编译后自动生成的构造函数、方法等的注释，提示构造函数、方法等不能被修改
 */
@Entity
public class Shop {
    //表示是购物车列表
    public static final int TYPE_CART = 0x01;
    //表示为收藏列表
    public static final int TYPE_LOVE = 0x02;

    //不能用int （ID 表示标识主键 且主键不能用int autoincrement = true 表示主键会自增）
    @Id(autoincrement = false)
    private Long id;

    //商品名称 (unique 表示该属性必须在数据库中是唯一的值)
    @Unique
    private String name;

    //商品价格(可以自定义字段名，注意外键不能使用该属性)
    @Property(nameInDb = "price")
    private String price;

    //已售数量
    private int sell_num;

    //图标url
    private String image_url;

    //商家地址
    private String address;

    //商品列表分类
    private int type;

    @Generated(hash = 1304458862)
    public Shop(Long id, String name, String price, int sell_num, String image_url,
            String address, int type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sell_num = sell_num;
        this.image_url = image_url;
        this.address = address;
        this.type = type;
    }

    @Generated(hash = 633476670)
    public Shop() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return this.price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getSell_num() {
        return this.sell_num;
    }

    public void setSell_num(int sell_num) {
        this.sell_num = sell_num;
    }

    public String getImage_url() {
        return this.image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
