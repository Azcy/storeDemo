package com.zcy.storeDemo.service.impl;

import com.zcy.storeDemo.beans.Goods;
import com.zcy.storeDemo.beans.ShopCart;
import com.zcy.storeDemo.model.dao.ShopCartDao;
import com.zcy.storeDemo.service.ShopCartService;

import java.util.List;

/**
 * Created by zcy on 2017/6/20.
 */
public class ShopChartServiceImpl implements ShopCartService {
    private ShopCartDao dao;

    public ShopCartDao getDao() {
        return dao;
    }

    public void setDao(ShopCartDao dao) {
        this.dao = dao;
    }

    public void add(ShopCart shopCart) {
        dao.add(shopCart);
    }

    public void delete(String username) {
        dao.delete(username);
    }

    public ShopCart get(int id) {
        return dao.get(id);
    }

    public void update(ShopCart shopCart) {
        dao.update(shopCart);
    }

    public List<Goods> query(String username) {
        return dao.query(username);
    }

    public List<ShopCart> queryShopCart() {
        return  dao.queryShopCart();
    }
}
