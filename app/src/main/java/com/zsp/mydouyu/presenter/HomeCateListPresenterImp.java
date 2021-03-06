package com.zsp.mydouyu.presenter;

import android.os.Message;

import com.zsp.mydouyu.base.BasePresenter;
import com.zsp.mydouyu.base.BaseView;
import com.zsp.mydouyu.model.protocol.BaseProtocol;
import com.zsp.mydouyu.model.protocol.IHttpService;
import com.zsp.mydouyu.model.protocol.bean.CateListBean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/11/13.
 */

public class HomeCateListPresenterImp extends BasePresenter {
    public HomeCateListPresenterImp(BaseView baseView) {
        super(baseView);
    }


    public BaseProtocol.OnHttpCallback mCallback
            = new BaseProtocol.OnHttpCallback() {
        @Override
        public void onHttpSuccess(int reqType, Message msg) {
            if (reqType == IHttpService.TYPE_CATELIST) {
                // 处理并转换数据，回调用界面
                CateListBean cateListBean = (CateListBean) msg.obj;
                // 转换数据
                msg.obj = cateListBean;
                // 返回到界面
                baseView.onHttpSuccess(reqType, msg);
                return;
            }

           /* if (reqType == IHttpService.TYPE_SHOP_LIST) {
                // 处理并转换数据，回调用界面
                // 处理并转换数据
                ShopList bean = (ShopList) msg.obj;
                ArrayList pageData = new ArrayList();
                // 一页数据：10个商家
                pageData.addAll(bean.getShopList());

                // 加载显示一则广告
                if (bean.getShopList() != null
                        && bean.getShopList().size() == 10
                        && bean.getRecommendList() != null
                        && bean.getRecommendList().size() > 0) {
                    // 显示了10个家商后，才显示一则广告
                    pageData.add(bean.getRecommendList().get(0));
                }
                msg.obj = pageData;

                mPageNo++;

                if (pageData.size() < 1) {
                    Global.showToast("已经是最后一页了");
                }

                // 返回到界面
                baseView.onHttpSuccess(reqType, msg);
                return;
            }*/
        }

        @Override
        public void onHttpError(int reqType, String error) {
            baseView.onHttpError(reqType, error);
        }
    };

    public void getCateListData() {
        // P层 调用 M层
        mProtocol.getHomeCateList(mBaseCallback);
    }
}
