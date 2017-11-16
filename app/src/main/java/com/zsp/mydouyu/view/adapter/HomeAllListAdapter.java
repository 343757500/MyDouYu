package com.zsp.mydouyu.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.zsp.mydouyu.model.protocol.bean.CateListBean;
import com.zsp.mydouyu.view.MainFragment1;
import com.zsp.mydouyu.view.MainFragment2;
import com.zsp.mydouyu.view.RecommendFragment1;

import java.util.List;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述：
 *  备注消息：
 *  修改时间：2016/12/19 下午1:53
 **/
public class HomeAllListAdapter extends FragmentStatePagerAdapter {

    private  List<CateListBean.DataBean> mHomeCateLists;
    private  String[] mTiltle;
    private FragmentManager mFragmentManager;

    public HomeAllListAdapter(FragmentManager fm, List<CateListBean.DataBean> homeCateLists, String[] title)
    {
        super(fm);
        this.mFragmentManager=fm;
        this.mHomeCateLists=homeCateLists;
        this.mTiltle=title;
    }
    @Override
    public int getCount() {
        return mTiltle.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mTiltle[position];
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0)
        {
            return new RecommendFragment1();
        }
      //  OtherHomeFragment otherHomeFragment= OtherHomeFragment.getInstance(mHomeCateLists.get(position-1),position);
        return new MainFragment2();
    }
//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        container.removeView(((Fragment) object).getView()); // 移出viewpager两边之外的page布局
//    }
//    @Override
//    public Object instantiateItem(ViewGroup container, int position) {
//        Fragment fragment = getItem(position);
//        if (!fragment.isAdded()) { // 如果fragment还没有added
//            FragmentTransaction ft = mFragmentManager.beginTransaction();
//            ft.add(fragment, fragment.getClass().getSimpleName());
//            ft.commit();
//            mFragmentManager.executePendingTransactions();//同步的方式添加Fragment
//        }
//        if (fragment.getView().getParent() == null) {
//            container.addView(fragment.getView()); // 为viewpager增加布局
//        }
//        return fragment;
//    }

//    @Override
//    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
////        if (position <= getCount()) {
////            FragmentManager manager = ((Fragment) object).getFragmentManager();
////            FragmentTransaction trans = manager.beginTransaction();
////            trans.remove((Fragment) object);
////            trans.commit();
////        }
//    }

}
