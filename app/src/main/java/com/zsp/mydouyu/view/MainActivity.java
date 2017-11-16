package com.zsp.mydouyu.view;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.zsp.mydouyu.R;
import com.zsp.mydouyu.view.adapter.MyFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import common.base.BaseActivity;
import common.base.Global;
import common.ui.GradientTab;

public class MainActivity extends BaseActivity {
    private String[] titles = new String[] {
            "首页", "直播", "视频", "关注","我的"
    };

    private int[] icons = new int[] {
            R.mipmap.home_pressed,
            R.mipmap.live_pressed,
            R.mipmap.video,
            R.mipmap.follow_pressed,
            R.mipmap.user_pressed,
    };

    private int[] iconsSelected = new int[] {
            R.mipmap.home_selected,
            R.mipmap.live_selected,
            R.mipmap.video_selected,
            R.mipmap.follow_selected,
            R.mipmap.user_selected,
    };

    /** 选项卡控件 */
    private GradientTab[] mTabs = new GradientTab[5];

    /** 当前选中的选项卡 */
    private GradientTab mCurrentTab;

    private LinearLayout llTabLayout;
    private ViewPager viewPager;
    private MainFragment1 mainFragment1;
    private MainFragment2 mainFragment2;
   /* private MainFragment3 mainFragment3;
    private MainFragment4 mainFragment4;
    private MainFragment5 mainFragment5;*/

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        llTabLayout = findView(R.id.ll_tab_layout);
        viewPager = findView(R.id.view_pager);

        initTab();
        initViewPager();

        // 状态栏透明
       // Global.setNoStatusBarFullMode(this);
    }

    @Override
    public void initListener() {
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int
                    positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                onTabSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /** 选项卡切换了*/
    private void onTabSelected(int position) {
        mCurrentTab.setTabSelected(false);  // 取消高亮

        mCurrentTab = mTabs[position];

        mCurrentTab.setTabSelected(true);   // 设置为高亮
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v, int id) {

    }

    private void initTab() {
        int padding = Global.dp2px(5); // 5dp
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
                0, LinearLayout.LayoutParams.MATCH_PARENT);
        param.weight = 1;   // 宽度平分
        for (int i = 0; i < titles.length; i++) {
            GradientTab tab = new GradientTab(this);
            mTabs[i] = tab;
            tab.setTag(i);  // 设置标识
            // 设置选项卡点击事件
            tab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = (int) v.getTag();
                    // 选项卡切换了
                    // onTabSelected(position);
                    // false： 禁用切换的动画
                    viewPager.setCurrentItem(position, false);
                }
            });

            // 设置标题和图标
            tab.setTextAndIcon(titles[i], icons[i], iconsSelected[i]);
            // 指定高亮显示的颜色
            tab.setHighlightColor(getResources().getColor(R.color.tab_text_pressed));
            tab.setPadding(padding, padding, padding, padding);

            // 设置未读条数
            // tab.setUnreadCount(3);
            // 有新消息: 显示红点
            // tab.setRedDotVisible(true);
            llTabLayout.addView(tab, param);
        }

        mCurrentTab = mTabs[0];  // 默认选中第一个
        mCurrentTab.setTabSelected(true);   // 选中，会高亮
    }

    private void initViewPager() {
        List<Fragment> fragments = new ArrayList<>();
        mainFragment1 = new MainFragment1();
        mainFragment2 = new MainFragment2();

        fragments.add(mainFragment1);
        fragments.add(mainFragment2);
        fragments.add(new MainFragment3());
        fragments.add(new MainFragment4());

        fragments.add(new MainFragment5());

        viewPager.setAdapter(new MyFragmentAdapter(
                getSupportFragmentManager(), fragments));
    }
}
