package com.zsp.mydouyu.presenter;

import android.os.Message;

import com.zsp.mydouyu.base.BasePresenter;
import com.zsp.mydouyu.base.BaseView;
import com.zsp.mydouyu.model.protocol.BaseProtocol;
import com.zsp.mydouyu.model.protocol.IHttpService;
import com.zsp.mydouyu.model.protocol.bean.CateListBean;
import com.zsp.mydouyu.model.protocol.bean.LunBoBean;

/**
 * Created by Administrator on 2017/11/13.
 */

public class RecommendFragment1PresenterImp extends BasePresenter {
    public RecommendFragment1PresenterImp(BaseView baseView) {
        super(baseView);
    }



    public void   getRecommendFragment1FaceList(int offset,int limit) {
        // P层 调用 M层
        mProtocol. getRecommendFragment1FaceList(offset,limit,mBaseCallback);
    }


    public void   getRecommendFragment1HotCate() {
        // P层 调用 M层
        mProtocol. getRecommendFragment1HotCate(mBaseCallback);
    }

    public void getRecommendFragment1HotList() {
        // P层 调用 M层
        mProtocol.getRecommendFragment1HotList(mBaseCallback);
    }

    public void getRecommendFragment1List() {
        // P层 调用 M层
        mProtocol.getRecommendFragment1List(mBaseCallback);
    }









}
