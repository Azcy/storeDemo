package com.zcy.storeDemo.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zcy.storeDemo.beans.User;
import com.zcy.storeDemo.service.UserService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;

/**
 * Created by zcy on 2017/6/20.
 */
public class RegistAction extends ActionSupport {
    private User user;
    private UserService userService;

    public User getUser() {
        return user;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void setUser(User user) {
        this.user = user;
    }

    HttpSession session;
    @Override
    public String execute() throws Exception {
        System.out.println("login----------------------test");
        //判断该id是否注册过
        User user1=userService.get(user.getUsername());
        System.out.println(user1);
        if (user1==null){
            //设置user登陆状态为false
            user.setState("0");
            //定义一个session
            session= ServletActionContext.getRequest().getSession();
            //把state放到sesson中 方便设置前端界面的响应。1为登陆成功，0为未登陆状态
            session.setAttribute("state","0");

            userService.add(user);
            return SUCCESS;
        }else {
            return ERROR;
        }
    }
}
