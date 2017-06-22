package com.zcy.storeDemo.model.dao.impl;

import com.zcy.storeDemo.beans.User;
import com.zcy.storeDemo.model.dao.UserDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by zcy on 2017/6/18.
 */
public class UserDaoImpl implements UserDao {

    //session工厂方法
    private SessionFactory sessionFactory;

    //注入sessionFactory
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    public void update(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public void delete(int id) {
        //获取session
        Session session=sessionFactory.getCurrentSession();
        //通过id找到对应的User
        User user1= (User) session.get(User.class,id);
        //删除user1
        session.delete(user1);
    }

    //通过账号进行查询，返回User
    public User get(String username) {
        User user=null;
        String hql="from User as us where us.username=?";
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery(hql);
        List<User> userList= query.setString(0,username).list();
        if (userList.size()>0){
            user= userList.get(0);
        }
        return user;

    }

    public List<User> query() {

        return null;
    }
}
