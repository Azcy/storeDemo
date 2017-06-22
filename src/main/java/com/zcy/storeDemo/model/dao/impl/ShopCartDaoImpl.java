package com.zcy.storeDemo.model.dao.impl;

import com.zcy.storeDemo.beans.Goods;
import com.zcy.storeDemo.beans.ShopCart;
import com.zcy.storeDemo.model.dao.ShopCartDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;

import java.util.Iterator;
import java.util.List;

/**
 * Created by zcy on 2017/6/20.
 */
public class ShopCartDaoImpl implements ShopCartDao {

    private ShopCart shopCart;

    //session工厂方法
    private SessionFactory sessionFactory;

    public ShopCart getShopCart() {
        return shopCart;
    }

    public void setShopCart(ShopCart shopCart) {
        this.shopCart = shopCart;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(ShopCart shopCart) {
        sessionFactory.getCurrentSession().save(shopCart);
    }

    public void delete(String username) {
        //获取session
        Session session=sessionFactory.getCurrentSession();
        //通过id找到对应的User
        ShopCart shopCart= (ShopCart) session.get(ShopCart.class,username);
        //删除user1
        session.delete(shopCart);
    }

    public List<Goods> query(String username) {

        String hql="select Goods.goodsId,goodsComment,goodsConsult,goodsDescription,goodsName,goodsNumber,goodsParameter,goodsPrice,img " +
                " from (Goods,ShopCart) where Goods.goodsId =ShopCart.goodsId and exists(select user.username from user where user.username='"+username+"')";


        //setResultTransformer 将sql查询的语句转成实体类Goods
        return sessionFactory.getCurrentSession().createSQLQuery(hql).setResultTransformer(Transformers.aliasToBean(Goods.class)).list();

    }

    public List<ShopCart> queryShopCart() {
        String hql="from ShopCart";
        return sessionFactory.getCurrentSession().createQuery(hql).list();

    }

    //通过id获取ShopCart对象
    public ShopCart get(int id) {
        ShopCart shopCart = null;
        String hql = "from ShopCart  where goodsId=?";
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        List<ShopCart> userList = query.setString(0, String.valueOf(id)).list();
        if (userList.size() > 0) {
            shopCart = userList.get(0);
        }
        return shopCart;
    }

    //更新操作
    public void update(ShopCart shopCart){
        sessionFactory.getCurrentSession().saveOrUpdate(shopCart);
    }
}
