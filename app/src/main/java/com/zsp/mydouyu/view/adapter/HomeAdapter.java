package com.zsp.mydouyu.view.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.zsp.mydouyu.model.protocol.bean.LunBoBean;
import com.zsp.mydouyu.model.protocol.bean.Recommend1Face;
import com.zsp.mydouyu.model.protocol.bean.Recommend1Hot;
import com.zsp.mydouyu.model.protocol.bean.Recommend1HotCate;
import com.zsp.mydouyu.view.holder.LunBoHeaderHolder;
import com.zsp.mydouyu.view.holder.Recommend1FaceHolder;
import com.zsp.mydouyu.view.holder.Recommend1HotCateHolder;
import com.zsp.mydouyu.view.holder.Recommend1HotHolder;

import java.util.List;

import common.ui.BaseAdapterRV;
import common.ui.BaseHolderRV;

import static com.zsp.mydouyu.model.protocol.IHttpService.TYPE_SHOP_LIST;

/**
 * Created by Administrator on 2017/11/15.
 */

public class HomeAdapter extends BaseAdapterRV<String>{
    private static final int TYPE_LUNBO = 0;
    private static final int TYPE_RECOMMEND1_HOME = 1;
    private static final int TYPE_FACE = 2;
    private static final int TYPE_HOTCATE = 3;


    public HomeAdapter(Context context, List<String> listData) {
        super(context, listData);
    }

    @Override
    public BaseHolderRV<String> createViewHolder(Context context, ViewGroup parent, int viewType) {
        if (viewType==TYPE_LUNBO){
            return new LunBoHeaderHolder(context, parent, this, viewType);
        }
        if (viewType==TYPE_RECOMMEND1_HOME){
            return new Recommend1HotHolder(context, parent, this, viewType);
        }

        if (viewType==TYPE_FACE){
            return new Recommend1FaceHolder(context, parent, this, viewType);
        }

        if (viewType==TYPE_HOTCATE){
            return new Recommend1HotCateHolder(context, parent, this, viewType);
        }
        return null;
    }


    @Override
    public int getItemViewType(int position) {
        Object obj = getItem(position);
        if (obj instanceof LunBoBean) {                      // 头部item
            return TYPE_LUNBO;
        }

       if (obj instanceof Recommend1Hot) {      // 首页推荐热门
            return TYPE_RECOMMEND1_HOME;
        }

        if (obj instanceof Recommend1Face) { // 广告item
            return TYPE_FACE;
        }

        if (obj instanceof Recommend1HotCate) { // 广告item
            return TYPE_HOTCATE;
        }

        return TYPE_SHOP_LIST;
    }
}
