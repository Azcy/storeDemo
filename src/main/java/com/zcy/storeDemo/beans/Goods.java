package com.zcy.storeDemo.beans;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by zcy on 2017/6/20.
 * 商品类（商品编号，商品名，价格，数量，商品介绍，商品参数，商品评论，商品咨询）
 * 商品参数（级别，标重，浮动）
 *
 */
@Entity
@Table(name = "Goods")
public class Goods {
    private int goodsId;
    private String goodsName;
    private String goodsPrice;
    private String goodsNumber;
    private String goodsDescription;
    private String goodsParameter;
    private String goodsComment;
    private String goodsConsult;
    private String img;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    @Column
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    @Column
    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    @Column
    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    @Column
    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    @Column
    public String getGoodsParameter() {
        return goodsParameter;
    }

    public void setGoodsParameter(String goodsParameter) {
        this.goodsParameter = goodsParameter;
    }

    @Column
    public String getGoodsComment() {
        return goodsComment;
    }

    public void setGoodsComment(String goodsComment) {
        this.goodsComment = goodsComment;
    }

    @Column
    public String getGoodsConsult() {
        return goodsConsult;
    }

    public void setGoodsConsult(String goodsConsult) {
        this.goodsConsult = goodsConsult;
    }

    @Column
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice='" + goodsPrice + '\'' +
                ", goodsNumber='" + goodsNumber + '\'' +
                ", goodsDescription='" + goodsDescription + '\'' +
                ", goodsParameter='" + goodsParameter + '\'' +
                ", goodsComment='" + goodsComment + '\'' +
                ", goodsConsult='" + goodsConsult + '\'' +
                ", img='" + img + '\'' +
                '}';
    }
}
