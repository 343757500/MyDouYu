package com.zsp.mydouyu.view;

import android.os.Bundle;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.flyco.tablayout.SlidingTabLayout;
import com.zsp.mydouyu.R;
import com.zsp.mydouyu.model.protocol.IHttpService;
import com.zsp.mydouyu.model.protocol.bean.CateListBean;
import com.zsp.mydouyu.presenter.HomeCateListPresenterImp;
import com.zsp.mydouyu.view.adapter.HomeAllListAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import common.base.BaseFragment;

/**
 * Created by Administrator on 2017/11/13.
 */

public class MainFragment1 extends BaseFragment {
    Unbinder unbinder;
    private HomeAllListAdapter mAdapter;
    private String[] mTitles;
    private ImageView imgSearch1;
    private ImageView imgHistory;
    private ImageView imgScanner;
    private ImageView imgMessage;
    private SlidingTabLayout slidingTab;
    private ViewPager viewpager;

    @Override
    public int getLayoutRes() {
        return R.layout.fragment1;
    }

    @Override
    public void initView() {
        imgSearch1 = findView(R.id.img_search);
        imgHistory = findView(R.id.img_history);
        imgScanner = findView(R.id.img_scanner);
        imgMessage = findView(R.id.img_message);
        slidingTab = findView(R.id.sliding_tab);
        viewpager = findView(R.id.viewpager);
    }

    @Override
    public void initListener() {

    }

    @Inject
    HomeCateListPresenterImp presenter;
    public HomeCateListPresenterImp getPresenter() {
        return presenter;
    }

    @Override
    public void initData() {
        presenter = new HomeCateListPresenterImp(this);
        presenter.getCateListData();
    }

    @Override
    public void onClick(View v, int id) {

    }

    @Override
    public void onHttpSuccess(int reqType, Message message) {
        super.onHttpSuccess(reqType, message);
        if (reqType == IHttpService.TYPE_CATELIST) {
            CateListBean cateListBean = (CateListBean) message.obj;
            List<CateListBean.DataBean> cateLists = cateListBean.getData();
            /**
             *  默认数据
             */
            mTitles = new String[cateLists.size()+1];
            mTitles[0]="推荐";
//        mFragments.add(RecommendHomeFragment.getInstance());
            for (int i=0;i<cateLists.size();i++)
            {
                mTitles[i+1]=cateLists.get(i).getTitle();
//            Bundle bundle=new Bundle();
//             bundle.putSerializable("homecatelist",cateLists.get(i));
//            mFragments.add(OtherHomeFragment.getInstance(bundle));
            }
//        不摧毁Fragment
                viewpager.setOffscreenPageLimit(mTitles.length);
                mAdapter = new HomeAllListAdapter(getChildFragmentManager(), cateLists, mTitles);
                viewpager.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
                slidingTab.setViewPager(viewpager, mTitles);
        }
    }

    @Override
    public void onHttpError(int reqType, String error) {
        super.onHttpError(reqType, error);
        if (reqType == IHttpService.TYPE_CATELIST) {
            showToast("请求失败：" + error);
        }
    }
}
