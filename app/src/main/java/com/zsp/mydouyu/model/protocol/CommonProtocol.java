package com.zsp.mydouyu.model.protocol;


import com.zsp.mydouyu.model.protocol.bean.CateListBean;
import com.zsp.mydouyu.model.protocol.bean.LunBoBean;
import com.zsp.mydouyu.model.protocol.bean.Recommend1Hot;

import java.util.HashMap;
import java.util.Map;


/**
 * 网络请求
 *
 * @author WJQ
 */
public class CommonProtocol extends BaseProtocol {

/*  *//*  *//**//** 创建订单 *//**//*
    public void createOrder(final OnHttpCallback callback, String payInfo) {
        super.execute(super.getHttpService().createOrder(payInfo),
                callback, IHttpService.TYPE_CREATE_ORDER, CreateOrder.class);
    }

    *//**//** 获取订单列表数据 *//**//*
    public void getOrderList(final OnHttpCallback callback, String token, String username) {
        super.execute(super.getHttpService().getOrderList(username, token),
                callback, IHttpService.TYPE_ORDER_LIST, OrderList.class);
    }

    *//**//** 获取首页数据 *//**//*
    public void getHomeData(final OnHttpCallback callback) {
        super.execute(super.getHttpService().getHomeData(),
                callback, IHttpService.TYPE_HOME, Home.class);
    }

    *//**//** 登录：使用电话号码登录 *//**//*
    public void login(final OnHttpCallback callback, String phone) {
        super.execute(super.getHttpService().login(
                IHttpService.TYPE_LOGIN_PHONE, phone),
                callback, IHttpService.TYPE_LOGIN, Login.class);
    }

    *//**//** 登录：使用账号密码登录 *//**//*
    public void login(final OnHttpCallback callback,
                      String username, String password) {
        super.execute(super.getHttpService().login(
                IHttpService.TYPE_LOGIN_NORMAL, username, password),
                callback, IHttpService.TYPE_LOGIN_2, Login.class);
    }

    *//**//** 获取商家排序条件数据 *//**//*
    public void getOrderBy(final OnHttpCallback callback) {
        super.execute(super.getHttpService().getOrderBy(),
                callback, IHttpService.TYPE_ORDER_BY, OrderBy.class);
    }


    *//**//**
     * 获取商家的所有商品及对应类别
     *  shopId : 商家id
     *//**//*
    public void getShopDetail(final OnHttpCallback callback, int shopId) {
        super.execute(super.getHttpService().getShopDetail(shopId),
                callback, IHttpService.TYPE_SHOP_DETAIL, ShopDetail.class);
    }

    *//**//** 获取商家类别 *//**//*
    public void getShopCategory(final OnHttpCallback callback) {
        super.execute(super.getHttpService().getShopCategory(),
                callback, IHttpService.TYPE_SHOP_CATEGORY, ShopCategory.class);
    }*/



    //  创建订单
    public void getHomeCateList(final OnHttpCallback callback) {
        super.execute(super.getHttpService().getHomeCateList(),
                callback, IHttpService.TYPE_CATELIST, CateListBean.class);
    }

    //  首页推荐页轮播图
    public void getRecommendFragment1List(final OnHttpCallback callback) {
        super.execute(super.getHttpService().getRecommendFragment1List(),
                callback, IHttpService.TYPE_RECOMMEND, LunBoBean.class);
    }

    //  首页推荐页轮播图
    public void getRecommendFragment1HotList(final OnHttpCallback callback) {
        super.execute(super.getHttpService().getRecommendFragment1HotList(),
                callback, IHttpService.TYPE_RECOMMENDHOT, Recommend1Hot.class);
    }
}
