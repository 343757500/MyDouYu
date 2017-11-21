package com.zsp.mydouyu.view;

import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.liaoinstan.springview.container.MeituanFooter;
import com.liaoinstan.springview.container.MeituanHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.zsp.mydouyu.R;
import com.zsp.mydouyu.model.protocol.IHttpService;
import com.zsp.mydouyu.model.protocol.bean.CateListBean;
import com.zsp.mydouyu.model.protocol.bean.LunBoBean;
import com.zsp.mydouyu.model.protocol.bean.Recommend1Face;
import com.zsp.mydouyu.model.protocol.bean.Recommend1Hot;
import com.zsp.mydouyu.model.protocol.bean.Recommend1HotCate;
import com.zsp.mydouyu.presenter.RecommendFragment1PresenterImp;
import com.zsp.mydouyu.view.adapter.HomeAdapter;
import com.zsp.mydouyu.view.adapter.HomeAllListAdapter;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import common.base.BaseFragment;
import common.base.Global;
import common.util.Utils;

/**
 * Created by Administrator on 2017/11/13.
 */

public class RecommendFragment1 extends BaseFragment {
    /** RecyclerView显示的数据集合 */
    private List listData = new ArrayList();
    private SpringView springView;
    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;
    @Inject
    RecommendFragment1PresenterImp recommendFragment1PresenterImp;
    private List d =new ArrayList();
    private List c=new ArrayList();
    private List b=new ArrayList();
    private List a=new ArrayList();
    //private SliderLayout sliderLayout;

    @Override
    public int getLayoutRes() {
        return R.layout.recommend_fragment1;
    }

    @Override
    public void initView() {

        springView = findView(R.id.spring_view);
        recyclerView = findView(R.id.recycler_view);
        springView.setHeader(new MeituanHeader(mActivity));
        springView.setFooter(new MeituanFooter(mActivity));
        springView.setType(SpringView.Type.FOLLOW);

        springView.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {   // 下拉刷新
                 showToast("下拉刷新");
                listData.clear();
                a.clear();
                b.clear();
                c.clear();
                d.clear();
                recommendFragment1PresenterImp.getRecommendFragment1List();
                recommendFragment1PresenterImp.getRecommendFragment1HotList();
                recommendFragment1PresenterImp. getRecommendFragment1FaceList(0,4);
                recommendFragment1PresenterImp.getRecommendFragment1HotCate();
            }

            @Override
            public void onLoadmore() {  // 加载更多
                showToast("加载更多");
               // presenter.getShopList(getShopCategory(), getOrderBy(), false);
            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        homeAdapter = new HomeAdapter(getActivity(),null);
        recyclerView.setAdapter(homeAdapter);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

        recommendFragment1PresenterImp = new RecommendFragment1PresenterImp(this);

        recommendFragment1PresenterImp.getRecommendFragment1List();
        recommendFragment1PresenterImp.getRecommendFragment1HotList();
        recommendFragment1PresenterImp. getRecommendFragment1FaceList(0,4);
        recommendFragment1PresenterImp.getRecommendFragment1HotCate();
    }

    @Override
    public void onClick(View v, int id) {

    }



    public List getListData() {
        return listData;
    }

    public HomeAdapter getHomeAdapter() {
        return homeAdapter;
    }

    @Override
    public void onHttpSuccess(int reqType, Message message) {
        super.onHttpSuccess(reqType, message);
        if (reqType == IHttpService.TYPE_RECOMMEND) {
            LunBoBean lunBoBean = (LunBoBean) message.obj;
            if (lunBoBean!=null) {
                a = new ArrayList();
                a.add(lunBoBean);
            //    listData.add(0,lunBoBean);

               // homeAdapter.setDatas(listData);
            }
        }

        if (reqType == IHttpService.TYPE_RECOMMENDHOT){
            Recommend1Hot recommend1Hot = (Recommend1Hot) message.obj;
            if (recommend1Hot!=null) {
                b = new ArrayList();
                b.add(recommend1Hot);
              //  listData.add(1,recommend1Hot);

               // homeAdapter.setDatas(listData);
            }
        }

        if (reqType==IHttpService.TYPE_RECOMMENDFACE){
            Recommend1Face recommend1Face=(Recommend1Face) message.obj;
            if (recommend1Face!=null) {
                c = new ArrayList();
                c.add(recommend1Face);
               // listData.add(2,recommend1Face);

                //homeAdapter.setDatas(listData);
            }
        }

        if (reqType==IHttpService.TYPE_RECOMMENDHOTCATE){
            Recommend1HotCate recommend1HotCate= (Recommend1HotCate) message.obj;
            if (recommend1HotCate!=null) {
                List<Recommend1HotCate.DataBean> data = recommend1HotCate.getData();
                d = new ArrayList();
               // d.add(recommend1Face);
                for (int i = 0; i < data.size(); i++) {
                    d.add(i,recommend1HotCate);
                   // listData.add(3+i, recommend1HotCate);
                }
               // homeAdapter.setDatas(listData);
            }
        }
        if (a.size()>0&&b.size()>0&&c.size()>0&&d.size()>0) {
            listData.add(0, a.get(0));
            listData.add(1, b.get(0));
            listData.add(2, c.get(0));
            for (int i = 0; i < d.size(); i++) {
                listData.add(3+i,d.get(i));
            }
            homeAdapter.setDatas(listData);
        }

    }

    @Override
    public void onHttpError(int reqType, String error) {
        super.onHttpError(reqType, error);
        if (reqType == IHttpService.TYPE_CATELIST) {
            showToast("请求失败：" + error);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        listData.clear();
    }
}
