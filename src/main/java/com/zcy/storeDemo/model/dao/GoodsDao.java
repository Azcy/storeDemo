package com.zcy.storeDemo.model.dao;

import com.zcy.storeDemo.beans.Goods;

import java.util.List;

/**
 * Created by zcy on 2017/6/20.
 */
public interface GoodsDao {
    //添加商品
    public void add(Goods goods);
    //删除商品
    public void delete(int id);
    //通过id查找指定商品
    public Goods get(int id);
    //遍历所有商品返回商品
    public List<Goods> query();

}
