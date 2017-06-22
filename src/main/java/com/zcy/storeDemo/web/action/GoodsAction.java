package com.zcy.storeDemo.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zcy.storeDemo.beans.Goods;
import com.zcy.storeDemo.service.GoodsService;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zcy on 2017/6/20.
 */
public class GoodsAction extends ActionSupport {

    private GoodsService goodsService;
    public GoodsService getGoodsService() {
        return goodsService;
    }

    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }




    @Override
    public String execute() throws Exception {



        List<Goods> goodsList =goodsService.query();
        HttpSession session= ServletActionContext.getRequest().getSession();
        session.setAttribute("goodsList",goodsList);
        return SUCCESS;
    }
}
