package com.zsp.mydouyu.view.holder;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zsp.mydouyu.R;
import com.zsp.mydouyu.model.protocol.bean.Recommend1Hot;
import com.zsp.mydouyu.model.protocol.bean.Recommend1HotCate;
import com.zsp.mydouyu.view.adapter.HomeAdapter;
import com.zsp.mydouyu.view.adapter.RecommentHotAdapter;

import java.util.List;

import common.ui.BaseAdapterRV;
import common.ui.BaseHolderRV;

/**
 * Created by Administrator on 2017/11/20.
 */

public class Recommend1HotCateHolder extends BaseHolderRV {
    public ImageView img_column_icon;
    //        栏目 名称
    public TextView tv_column_name;
    //        加载更多
    public RelativeLayout rl_column_more;
    //        栏目列表
    public RecyclerView rv_column_list;

    public LinearLayout item_home_recommed_girdview;

    public Recommend1HotCateHolder(Context context, ViewGroup parent, BaseAdapterRV<String> adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_home_recommend);
    }

    @Override
    public void onFindViews(View itemView) {
        img_column_icon = (ImageView) itemView.findViewById(R.id.img_column_icon);
        tv_column_name = (TextView) itemView.findViewById(R.id.tv_column_name);
        rl_column_more = (RelativeLayout) itemView.findViewById(R.id.rl_column_more);
        rv_column_list = (RecyclerView) itemView.findViewById(R.id.rv_column_list);
        item_home_recommed_girdview = (LinearLayout) itemView.findViewById(R.id.item_home_recommed_girdview);
    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        Recommend1HotCate recommend1HotCate= (Recommend1HotCate)bean;
        List<Recommend1HotCate.DataBean> data = recommend1HotCate.getData();

        img_column_icon.setImageResource(R.mipmap.icon_column);
        tv_column_name.setText(data.get(position-3).getTag_name());

        RecommentHotAdapter homeAdapter=new RecommentHotAdapter(context,null);
        rv_column_list.setLayoutManager(new GridLayoutManager(rv_column_list.getContext(), 2, GridLayoutManager.VERTICAL, false));
        rv_column_list.setAdapter(homeAdapter);
        List<Recommend1HotCate.DataBean.RoomListBean> room_list = data.get(position-3).getRoom_list();
        homeAdapter.setDatas(room_list);
    }
}
