package com.zsp.mydouyu.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.zsp.mydouyu.model.protocol.bean.LunBoBean;
import com.zsp.mydouyu.model.protocol.bean.Recommend1Face;
import com.zsp.mydouyu.model.protocol.bean.Recommend1Hot;
import com.zsp.mydouyu.model.protocol.bean.Recommend1HotCate;
import com.zsp.mydouyu.view.holder.Recommend1FaceHolder;
import com.zsp.mydouyu.view.holder.Recommend1HotCateHolder;
import com.zsp.mydouyu.view.holder.RecommendFaceHolder;
import com.zsp.mydouyu.view.holder.RecommendHotCateHolder;
import com.zsp.mydouyu.view.holder.RecommentHotHolder;

import java.util.List;

import common.ui.BaseAdapterLV;
import common.ui.BaseAdapterRV;
import common.ui.BaseHolderLV;
import common.ui.BaseHolderRV;

import static com.zsp.mydouyu.model.protocol.IHttpService.TYPE_SHOP_LIST;

/**
 * Created by Administrator on 2017/11/16.
 */

public class RecommentHotAdapter extends BaseAdapterRV{

    private static final int TYPE_LUNBO = 0;
    private static final int TYPE_RECOMMEND1_HOME = 1;
    private static final int TYPE_FACE = 3;
    private static final int TYPE_RECOMMEND1_HOME_CATE = 4;

    public RecommentHotAdapter(Context context, List listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV createViewHolder(Context context, ViewGroup parent, int viewType) {
        if (viewType==TYPE_LUNBO) {
            return new RecommentHotHolder(context, parent, this, viewType);
        }
        if (viewType==TYPE_RECOMMEND1_HOME) {
            return new RecommendFaceHolder(context, parent, this, viewType);
        }

        if (viewType==TYPE_RECOMMEND1_HOME_CATE){
            return new RecommendHotCateHolder(context, parent, this, viewType);
        }

          return new RecommentHotHolder(context, parent, this, viewType);
    }


    @Override
    public int getItemViewType(int position) {
        Object obj = getItem(position);
        if (obj instanceof Recommend1Hot.DataBean) {                      // 头部item
            return TYPE_LUNBO;
        }

        if (obj instanceof Recommend1Face.DataBean) {      // 首页推荐热门
            return TYPE_RECOMMEND1_HOME;
        }

        if (obj instanceof Recommend1Face) { // 广告item
            return TYPE_FACE;
        }

        if (obj instanceof Recommend1HotCate.DataBean.RoomListBean) { // 广告item
            return TYPE_RECOMMEND1_HOME_CATE;
        }

        return TYPE_SHOP_LIST;
    }
}
