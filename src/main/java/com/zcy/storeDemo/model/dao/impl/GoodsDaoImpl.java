package com.zcy.storeDemo.model.dao.impl;

import com.zcy.storeDemo.beans.Goods;
import com.zcy.storeDemo.model.dao.GoodsDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by zcy on 2017/6/20.
 */
public class GoodsDaoImpl implements GoodsDao {
    private Goods goods;
    //session工厂方法
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    //添加商品
    public void add(Goods goods) {
        sessionFactory.getCurrentSession().save(goods);
    }

    //删除商品
    public void delete(int id) {
        //获取session
        Session session=sessionFactory.getCurrentSession();
        //通过id找到对应的User
        Goods goods1= (Goods) session.get(Goods.class,id);
        //删除user1
        session.delete(goods1);
    }

    //查询指定商品
    public Goods get(int id) {
        Goods goods=null;
        String hql="from Goods as good where good.goodsId=?";
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery(hql);
        List<Goods> userList= query.setString(0, String.valueOf(id)).list();
        if (userList.size()>0){
            goods= userList.get(0);
        }
        return goods;

    }

    //获取所有商品信息
    public List<Goods> query() {
        String hql="from Goods";
        return sessionFactory.getCurrentSession().createQuery(hql).list();

    }
}
