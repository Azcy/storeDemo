package com.zcy.storeDemo.service.impl;

import com.zcy.storeDemo.beans.Goods;
import com.zcy.storeDemo.model.dao.GoodsDao;
import com.zcy.storeDemo.service.GoodsService;

import java.util.List;

/**
 * Created by zcy on 2017/6/20.
 */
public class GoodsServiceImpl implements GoodsService{

    private GoodsDao dao;

    public GoodsDao getDao() {
        return dao;
    }

    public void setDao(GoodsDao dao) {
        this.dao = dao;
    }

    public void add(Goods goods) {
        dao.add(goods);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    public Goods get(int id) {

        return dao.get(id);
    }

    public List<Goods> query() {
        return dao.query();
    }
}
