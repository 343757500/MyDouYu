package com.zsp.mydouyu.view.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.zsp.mydouyu.R;
import com.zsp.mydouyu.model.protocol.bean.Recommend1Hot;
import com.zsp.mydouyu.model.protocol.bean.Recommend1HotCate;
import com.zsp.mydouyu.view.adapter.RecommentHotAdapter;

import java.util.List;

import common.ui.BaseAdapterRV;
import common.ui.BaseHolderRV;
import common.util.Utils;

/**
 * Created by Administrator on 2017/11/20.
 */

public class RecommendHotCateHolder extends BaseHolderRV {
    private ImageView img_item_gridview;
    private TextView tv_nickname;
    private TextView tv_column_item_nickname;
    private TextView tv_online_num;
    public RecommendHotCateHolder(Context context, ViewGroup parent, BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_home_recommend_view);
    }

    @Override
    public void onFindViews(View itemView) {
        img_item_gridview = (ImageView) itemView.findViewById(R.id.img_item_gridview);
        tv_nickname = (TextView) itemView.findViewById(R.id.tv_nickname);
        tv_column_item_nickname = (TextView) itemView.findViewById(R.id.tv_column_item_nickname);
        tv_online_num = (TextView) itemView.findViewById(R.id.tv_online_num);
    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        Recommend1HotCate.DataBean.RoomListBean room_list  =(Recommend1HotCate.DataBean.RoomListBean) bean;
        String imageUrl = Utils.replaceIp(room_list.getVertical_src());
        Picasso.with(context).load(imageUrl).into(img_item_gridview);
        //img_item_gridview.setImageURI(Uri.parse(dataBean.getVertical_src()));
        tv_nickname.setText(room_list.getNickname());
        tv_column_item_nickname.setText(room_list.getRoom_name());
        tv_online_num.setText(room_list.getOnline());
    }
}
