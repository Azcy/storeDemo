package com.zcy.storeDemo.service.impl;


import com.zcy.storeDemo.beans.User;
import com.zcy.storeDemo.model.dao.UserDao;
import com.zcy.storeDemo.service.UserService;

import java.util.List;

/**
 * Created by zcy on 2017/6/18.
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void add(User user) {
        userDao.add(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public User get(String username) {
        return  userDao.get(username);
    }

    public List<User> query() {
        return null;
    }
}
