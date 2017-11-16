package com.zsp.mydouyu.model.protocol;

/**
 * @author WJQ
 */
import com.google.gson.JsonObject;

import java.util.Map;

import common.base.Const;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/** Retrofit接口 */
public interface IHttpService {

    String HOST_URL = "http://" + Const.HOST_IP + ":8080/TakeoutService/";

    //    Base地址
    public static String baseUrl = "http://capi.douyucdn.cn";

    //     OldBase地址
    public static String oldBaseUrl = "http://coapi.douyucdn.cn";

    //     视频接口 地址
    public static String baseVideoUrl = "https://apiv2.douyucdn.cn";

    //    0: 账号密码登录
//    1：手机号码登录
//    2: 第三方应用登录
    int TYPE_LOGIN_NORMAL = 0;
    int TYPE_LOGIN_PHONE = 1;
    int TYPE_LOGIN_THIRD_PART = 2;

    int TYPE_HOME = 0;
    int TYPE_SHOP_LIST = 1;
    int TYPE_SHOP_CATEGORY = 2;
    int TYPE_ORDER_BY = 3;
    int TYPE_SHOP_DETAIL = 4;
    int TYPE_LOGIN = 4;
    int TYPE_LOGIN_2 = 5;
    int TYPE_CREATE_ORDER = 6;
    int TYPE_LOGOUT = 7;
    int TYPE_ORDER_LIST = 8;

    int TYPE_CATELIST=9;
    int TYPE_RECOMMEND=10;
    int TYPE_RECOMMENDHOT=11;

    @GET("/api/homeCate/getCateList")
    Call<JsonObject> getHomeCateList();

    @GET("/api/v1/slide/6")
    Call<JsonObject> getRecommendFragment1List();


    @GET("/api/v1/getbigDataRoom")
    Call<JsonObject> getRecommendFragment1HotList();




    @POST("createOrder")
    @FormUrlEncoded
    Call<JsonObject> createOrder(
            @Field("payInfo") String payInfo);

    @POST("orderList")
    @FormUrlEncoded
    Call<JsonObject> getOrderList(
            @Field("username") String username,
            @Field("token") String token);

    @GET("login")
    Call<JsonObject> login(
            @Query("type") int type,
            @Query("phone") String phone);

    @GET("login")
    Call<JsonObject> login(
            @Query("type") int type,
            @Query("username") String username,
            @Query("password") String password);

    @GET("shopCategory")
    Call<JsonObject> getShopCategory();

    @GET("orderBy")
    Call<JsonObject> getOrderBy();

    @GET("shopDetail")
    Call<JsonObject> getShopDetail(@Query("shopId") int shopId);

    @POST("shopList")
    @FormUrlEncoded
    Call<JsonObject> getShopList(
            @FieldMap Map<String, Object> map);
}
