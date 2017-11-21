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


    //    Base地址
    public static String baseUrl = "http://capi.douyucdn.cn";


    int TYPE_SHOP_LIST = 1;

    int TYPE_CATELIST=9;
    int TYPE_RECOMMEND=10;
    int TYPE_RECOMMENDHOT=11;
    int TYPE_RECOMMENDFACE=12;
    int TYPE_RECOMMENDHOTCATE=13;
    int TYPE_PCLIVEVIDEOID=14;

    @GET("/api/homeCate/getCateList")
    Call<JsonObject> getHomeCateList();
    //    首页轮播
    @GET("/api/v1/slide/6")
    Call<JsonObject> getRecommendFragment1List();

    //    首页---推荐---热栏目
    @GET("/api/v1/getbigDataRoom")
    Call<JsonObject> getRecommendFragment1HotList();
    //    首页---颜值栏目
    @GET("/api/v1/getVerticalRoom")
    Call<JsonObject> getRecommendFragment1FaceList(
            @Query("offset") int type,
            @Query("limit") int phone);

    //    首页---推荐---热栏目
    @GET("/api/v1/getHotCate")
    Call<JsonObject> getRecommendFragment1HotCate();



}
