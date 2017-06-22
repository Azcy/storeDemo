package com.zcy.storeDemo.model.dao;

import com.zcy.storeDemo.beans.Goods;
import com.zcy.storeDemo.beans.ShopCart;

import java.util.List;

/**
 * Created by zcy on 2017/6/20.
 */
public interface ShopCartDao {
    public void  add(ShopCart shopCart);
    public void delete(String username);
    public List<Goods> query(String username);
    //返回所有shopCart
    public  List<ShopCart> queryShopCart();
    //通过id查找shopCart
    public ShopCart get(int id);
    //通过id，更新ShopCart
    public void update(ShopCart shopCart);
}
