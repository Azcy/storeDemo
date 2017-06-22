package com.zcy.storeDemo.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zcy.storeDemo.beans.Goods;
import com.zcy.storeDemo.beans.User;
import com.zcy.storeDemo.model.dao.impl.GoodsDaoImpl;
import com.zcy.storeDemo.service.GoodsService;
import com.zcy.storeDemo.service.UserService;
import com.zcy.storeDemo.service.impl.GoodsServiceImpl;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * Created by zcy on 2017/6/18.
 */
public class LoginAction extends ActionSupport {
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


    @Override
    public String execute() throws Exception {
        //通过username拉力获取数据库的user对象
        User user1=userService.get(user.getUsername());
        //输出用户输入的用户名和密码
        System.out.println(user1);
        System.out.println("login----------------------test user username:"+user.getUsername()+",password"+user.getPassword());
        //判断数据库中是否有对应username的user
        if (user1!=null){
            //判断用户名和密码是否匹配
            if (user1.getUsername().equals(user.getUsername())&&user1.getPassword().equals(user.getPassword())){
                //登陆成功
                //设置登陆状态
                user1.setState("1");
                //调用userService的update方法进行刷新数据库
                userService.update(user1);
                //test,输出user1的信息，方便查看
                System.out.println(user1);
                //定义一个session
                session= ServletActionContext.getRequest().getSession();
                //把state放到sesson中 方便设置前端界面的响应。1为登陆成功，0为未登陆状态
                session.setAttribute("state","1");
                //存放用户信息
                session.setAttribute("user",user);
                //把登录者用户名放进session中
                session.setAttribute("username",user1.getUsername());
                System.out.println("user1.getUsername()"+user1.getUsername());

                return SUCCESS;
            }else {

                return ERROR;
            }

        }else
        {
            return ERROR;
        }

    }

    HttpSession session;
    //注册方法
    public String regist() throws Exception {
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

    //登陆方法
    public String login() throws Exception{


        //通过username拉力获取数据库的user对象
        User user1=userService.get(user.getUsername());
        //输出用户输入的用户名和密码
        System.out.println(user1);
        System.out.println("login----------------------test user username:"+user.getUsername()+",password"+user.getPassword());
        //判断数据库中是否有对应username的user
        if (user1!=null){
            //判断用户名和密码是否匹配
            if (user1.getUsername().equals(user.getUsername())&&user1.getPassword().equals(user.getPassword())){
                //登陆成功
                //设置登陆状态
                user1.setState("1");
                //调用userService的update方法进行刷新数据库
                userService.update(user1);
                //test,输出user1的信息，方便查看
                System.out.println(user1);
                //定义一个session
                session= ServletActionContext.getRequest().getSession();
                //把state放到sesson中 方便设置前端界面的响应。1为登陆成功，0为未登陆状态
                session.setAttribute("state","1");
                //把登录者用户名放进session中
                session.setAttribute("username",user1.getUsername());
                System.out.println("user1.getUsername()"+user1.getUsername());

                return SUCCESS;
            }else {

                return ERROR;
            }

        }else
        {
            return ERROR;
        }

    }
}
