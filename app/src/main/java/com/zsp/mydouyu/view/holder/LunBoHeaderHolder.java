package com.zsp.mydouyu.view.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.zsp.mydouyu.R;
import com.zsp.mydouyu.model.protocol.bean.LunBoBean;
import com.zsp.mydouyu.view.adapter.HomeAdapter;

import java.util.List;

import common.base.Global;
import common.ui.BaseAdapterRV;
import common.ui.BaseHolderRV;
import common.util.Utils;

/**
 * Created by Administrator on 2017/11/16.
 */

public class LunBoHeaderHolder extends BaseHolderRV {

    private SliderLayout sliderLayout;

    public LunBoHeaderHolder(Context context, ViewGroup parent, BaseAdapterRV adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.lunbo_header);
    }

    @Override
    public void onFindViews(View itemView) {
        sliderLayout = (SliderLayout) itemView.findViewById(R.id.slider_layout);

    }

    @Override
    protected void onRefreshView(Object bean, int position) {
        LunBoBean lunBoBean=(LunBoBean)bean;

        initLooperImage(lunBoBean.getData());
    }

    /** 显示轮播图*/
    private void initLooperImage(List<LunBoBean.DataBean> promotionList) {
        // 选删除之前的选项
        sliderLayout.removeAllSliders();
        for (final LunBoBean.DataBean bean: promotionList) {
            TextSliderView textSliderView = new TextSliderView(context);
            // 修正ip地址
            String imageUrl = Utils.replaceIp(bean.getPic_url());
            textSliderView.description(bean.getTitle()).image(imageUrl);
            // 设置子界面的点击事件
            textSliderView.setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                @Override
                public void onSliderClick(BaseSliderView slider) {
                    Global.showToast("" + bean.getTitle());
                }
            });
            // 添加一个子界面
            sliderLayout.addSlider(textSliderView);
        }
    }
}
