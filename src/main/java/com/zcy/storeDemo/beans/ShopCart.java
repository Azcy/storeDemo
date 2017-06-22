package com.zcy.storeDemo.beans;

import javax.persistence.*;

/**
 * Created by zcy on 2017/6/20.
 * 购物车(id，用户名，购买的商品id)
 */
@Entity
@Table(name = "ShopCart")
public class ShopCart {
    private String username;
    private int goodsId;
    private  int num;


    @Id
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Column
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    @Column
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    public String toString() {
        return "ShopCart{" +
                "username='" + username + '\'' +
                ", goodsId=" + goodsId +
                ", num=" + num +
                '}';
    }
    //    @CollectionTable(name = "user",joinColumns = @JoinColumn(name = "username",nullable = false));
}
