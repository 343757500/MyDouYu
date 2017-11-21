package com.zsp.mydouyu.presenter;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.zsp.mydouyu.base.BasePresenter;
import com.zsp.mydouyu.base.BaseView;
import com.zsp.mydouyu.model.protocol.bean.VideoBean;
import com.zsp.mydouyu.view.IVideoView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/11/21.
 */

public class PcLiveVideoPresenter  {
   private  IVideoView iVideoView;
    public PcLiveVideoPresenter(IVideoView iVideoView) {
        this.iVideoView=iVideoView;
    }

    public void getPcLiveVideoUrl(String id) {


        // 2. 采用okhttp访问网络
        //2.1 构建一个okhttpClient
        final String url="https://m.douyu.com/html5/live?roomId="+id;
        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient okHttpClient=new OkHttpClient();
                //2.2 准备一个request请求
                Request request=new Request.Builder().url(url).build();
                //2.3 执行请求
                try {
                    Response response = okHttpClient.newCall(request).execute();
                    if(response.isSuccessful()) {

                        String result = response.body().string();
                        if (!TextUtils.isEmpty(result)) {
                            // P层 调用 M层
                            VideoBean videoBean = new Gson().fromJson(result, VideoBean.class);

                            iVideoView.getViewPcLiveVideoInfo(videoBean);
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }
}
