package com.zsp.mydouyu.view;

import android.net.Uri;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.zsp.mydouyu.R;
import com.zsp.mydouyu.model.protocol.bean.VideoBean;
import com.zsp.mydouyu.presenter.PcLiveVideoPresenter;

import common.base.BaseActivity;
import common.base.Global;
import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.VideoView;

/**
 * Created by Administrator on 2017/11/21.
 */

public class PcLiveVideoActivity extends BaseActivity implements IVideoView{

    private VideoView vm_videoview;
    private String room_id;
    private PcLiveVideoPresenter pcLiveVideoPresenter;

    @Override
    public int getLayoutRes() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        Vitamio.isInitialized(this);
        return R.layout.activity_pclive_video;
    }

    @Override
    public void initView() {
        vm_videoview = findView(R.id.vm_videoview);
        room_id = getIntent().getExtras().getString("Room_id");

        pcLiveVideoPresenter = new PcLiveVideoPresenter(this);
        pcLiveVideoPresenter.getPcLiveVideoUrl(room_id);

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v, int id) {

    }

    @Override
    public void getViewPcLiveVideoInfo(VideoBean videoBean) {
        String hls_url = videoBean.getData().getHls_url();
        final Uri uri = Uri.parse(hls_url);


        Global.runOnUIThread(new Runnable() {
            @Override
            public void run() {
                vm_videoview.setVideoURI(uri);
            }
        });
    }
}
