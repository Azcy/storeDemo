package com.zcy.storeDemo.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zcy.storeDemo.beans.Goods;
import com.zcy.storeDemo.beans.ShopCart;
import com.zcy.storeDemo.service.ShopCartService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zcy on 2017/6/20.
 */
public class ShopCartAction extends ActionSupport {
    private ShopCart shopCart;
    private ShopCartService shopCartService;
    public ShopCartService getShopCartService() {
        return shopCartService;
    }

    public void setShopCartService(ShopCartService shopCartService) {
        this.shopCartService = shopCartService;
    }

    public ShopCart getShopCart() {
        return shopCart;
    }

    public void setShopCart(ShopCart shopCart) {
        this.shopCart = shopCart;
    }
    HttpSession session;
    @Override
    public String execute() throws Exception {
        session= ServletActionContext.getRequest().getSession();
        System.out.println(shopCart);
        //把购物车的表写入session
        session.setAttribute("shopCart",shopCart);
       //session.setAttribute("num",shopCart.getNum());
        /*把物品添加进入购物车表*/
        //获取通过id查找的ShopCart对象，并且存储到shopCartGetByGoodsId对象中
        ShopCart shopCartGetByGoodsId=shopCartService.get(shopCart.getGoodsId());

        //判断获取的购物车对象是否为空
        if (shopCartGetByGoodsId!=null){
            //获取当前已经存在ShopCart对象的num
            int num1=shopCartGetByGoodsId.getNum();
           //更新的num=num1+当前的num
            int sum=num1+shopCart.getNum();
            shopCart.setNum(sum);
            //test
            System.out.println("---num1----"+num1+"------shopCart.getNum()------"+shopCart.getNum());
            //更新该对象的num，加上用户添加的数量
            //update
            shopCartService.update(shopCart);

        }else {
            //如果不能通过goodsId找到该ShopCart类，则添加进ShopCart表中
            shopCartService.add(shopCart);

        }
        //查询ShopCart表，返回所有ShopCart
        List <ShopCart> shopCartList=shopCartService.queryShopCart();
        //将查询到的ShopCart存储到内置对象Session中
        session.setAttribute("shopCartList",shopCartList);

        //通过shopCart商品的id，查找商品类
        List<Goods> shopCartGoodsList=shopCartService.query(shopCart.getUsername());
        session.setAttribute("shopCartGoodsList",shopCartGoodsList);
        for (int i=0;i<shopCartGoodsList.size();i++)
        {
            System.out.println(shopCartGoodsList.get(i));
        }
        return SUCCESS;

    }
}
