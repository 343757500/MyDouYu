package com.zsp.mydouyu.model.protocol.bean;

/**
 * Created by Administrator on 2017/11/21.
 */

public class VideoBean {
    /**
     * error : 0
     * data : {"hls_url":"http://hls3.douyucdn.cn/live/1164160rPgK66rZy_550/playlist.m3u8?wsSecret=4dff5d400da84d86609e44836bec595c&wsTime=1511230290&token=h5-douyu-0-1164160-a688c24e866fb88826f3bdef4837557f&did=h5_did"}
     */

    private int error;
    private DataBean data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * hls_url : http://hls3.douyucdn.cn/live/1164160rPgK66rZy_550/playlist.m3u8?wsSecret=4dff5d400da84d86609e44836bec595c&wsTime=1511230290&token=h5-douyu-0-1164160-a688c24e866fb88826f3bdef4837557f&did=h5_did
         */

        private String hls_url;

        public String getHls_url() {
            return hls_url;
        }

        public void setHls_url(String hls_url) {
            this.hls_url = hls_url;
        }
    }
}
