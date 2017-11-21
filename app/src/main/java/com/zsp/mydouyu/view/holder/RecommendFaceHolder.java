package com.zsp.mydouyu.view.holder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import com.zsp.mydouyu.R;
import com.zsp.mydouyu.model.protocol.bean.Recommend1Face;
import com.zsp.mydouyu.model.protocol.bean.Recommend1Hot;
import com.zsp.mydouyu.view.PcLiveVideoActivity;
import com.zsp.mydouyu.view.adapter.RecommentHotAdapter;

import common.ui.BaseAdapterRV;
import common.ui.BaseHolderRV;
import common.util.Utils;

/**
 * Created by Administrator on 2017/11/17.
 */

public class RecommendFaceHolder extends BaseHolderRV {
    private ImageView img_item_gridview;
    private TextView tv_facescore_city;
    private TextView tv_column_item_nickname;
    private TextView tv_online_num;

    public RecommendFaceHolder(Context context, ViewGroup parent, BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_home_recommend_facescore);
    }

    @Override
    public void onFindViews(View itemView) {
        img_item_gridview = (ImageView) itemView.findViewById(R.id.img_item_gridview);
        tv_facescore_city = (TextView) itemView.findViewById(R.id.tv_facescore_city);
        tv_column_item_nickname = (TextView) itemView.findViewById(R.id.tv_column_item_nickname);
        tv_online_num = (TextView) itemView.findViewById(R.id.tv_online_num);

    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        Recommend1Face.DataBean dataBean  =(Recommend1Face.DataBean) bean;
        String imageUrl = Utils.replaceIp(dataBean.getVertical_src());
        //Picasso.with(context).load(imageUrl).into(img_item_gridview);

        Glide.with(context).load(imageUrl).dontAnimate().override(400,1000).fitCenter().into(img_item_gridview);;
        //img_item_gridview.setImageURI(Uri.parse(dataBean.getVertical_src()));
        tv_facescore_city.setText(dataBean.getAnchor_city());
        tv_column_item_nickname.setText(dataBean.getRoom_name());
        tv_online_num.setText(dataBean.getOnline()+"");
    }

    @Override
    protected void onItemClick(View itemView, int position, Object bean) {
        Recommend1Face.DataBean bean1 = (Recommend1Face.DataBean) bean;
        Intent intent = new Intent(context, PcLiveVideoActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("Room_id",bean1.getRoom_id());
        intent.putExtras(bundle);
        context.startActivity(intent);
    }
}
