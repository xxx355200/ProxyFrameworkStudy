package com.yyy.proxyframeworkstudy.httpwork.okhttp;

import com.yyy.proxyframeworkstudy.httpwork.ICallback;

import java.io.IOException;
import java.util.Map;

/**
 * Author ：you
 * Date ：2018/4/26
 * 用于：
 */
public class OKHttpRequestPresenter implements IOkHttpReqeust{
    private static OKHttpRequestPresenter ourInstance;

    public static OKHttpRequestPresenter getInstance() {
        return ourInstance;
    }

    private OKHttpRequestPresenter() {
    }

    private IOkHttpReqeust httpReqeust;

    public static void init(IOkHttpReqeust httpReqeust){
        if (ourInstance == null){
            synchronized (OKHttpRequestPresenter.class){
                if (ourInstance == null){
                    ourInstance = new OKHttpRequestPresenter(httpReqeust);
                }
            }
        }

    }

    public OKHttpRequestPresenter(IOkHttpReqeust httpReqeust) {
        this.httpReqeust = httpReqeust;
    }


    @Override
    public void getOkhttp(String url, Map<String, String> params, ICallback callback){
        httpReqeust.getOkhttp(url, params, callback);
    }

    @Override
    public void postOkhttp(String url, Map<String, String> params, ICallback callback){
        httpReqeust.postOkhttp(url, params,callback);
    }
}
