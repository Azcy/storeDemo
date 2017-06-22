package com.zcy.storeDemo.service;


import com.zcy.storeDemo.beans.User;

import java.util.List;

/**
 * Created by zcy on 2017/6/18.
 */
public interface UserService {
    void add(User user);
    public void update(User user);

    public void delete(int id);

    public User get(String username);

    public List<User> query();
}
