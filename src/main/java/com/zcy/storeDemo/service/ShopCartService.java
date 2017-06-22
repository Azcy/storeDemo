package com.zcy.storeDemo.service;

import com.zcy.storeDemo.beans.Goods;
import com.zcy.storeDemo.beans.ShopCart;

import java.util.List;

/**
 * Created by zcy on 2017/6/20.
 */
public interface ShopCartService {
    public void  add(ShopCart shopCart);
    public void delete(String username);
    public ShopCart get(int id);
    public List<Goods> query(String username);
    public List<ShopCart> queryShopCart();
    public void update(ShopCart shopCart);
}
