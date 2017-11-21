package com.zsp.mydouyu.model.protocol;


import com.zsp.mydouyu.model.protocol.bean.CateListBean;
import com.zsp.mydouyu.model.protocol.bean.LunBoBean;
import com.zsp.mydouyu.model.protocol.bean.Recommend1Face;
import com.zsp.mydouyu.model.protocol.bean.Recommend1Hot;
import com.zsp.mydouyu.model.protocol.bean.Recommend1HotCate;

import java.util.HashMap;
import java.util.Map;


/**
 * 网络请求
 *
 * @author WJQ
 */
public class CommonProtocol extends BaseProtocol {

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

    //  首页推荐页热门
    public void getRecommendFragment1HotList(final OnHttpCallback callback) {
        super.execute(super.getHttpService().getRecommendFragment1HotList(),
                callback, IHttpService.TYPE_RECOMMENDHOT, Recommend1Hot.class);
    }

    //  首页推荐页颜值
    public void getRecommendFragment1FaceList(int offset,int limit,final OnHttpCallback callback) {
        super.execute(super.getHttpService().getRecommendFragment1FaceList(offset,limit),
                callback, IHttpService.TYPE_RECOMMENDFACE, Recommend1Face.class);
    }

    //  首页推荐页热门种类
    public void getRecommendFragment1HotCate(final OnHttpCallback callback) {
        super.execute(super.getHttpService().getRecommendFragment1HotCate(),
                callback, IHttpService.TYPE_RECOMMENDHOTCATE, Recommend1HotCate.class);
    }




}
