package com.yyy.proxyframeworkstudy.httpwork;


import java.util.Map;

/**
 * Author ：you
 * Date ：2018/4/24
 * 用于：
 */
public class HttpRequestPresenter implements IHttpRequest {

    private IHttpRequest httpRequest;

    private static volatile HttpRequestPresenter ourInstance;

    public static HttpRequestPresenter getInstance() {
        return ourInstance;
    }

    public static void init(IHttpRequest httpRequest) {
        if(ourInstance == null){
            synchronized (HttpRequestPresenter.class){
                if ( ourInstance == null)
                    ourInstance = new HttpRequestPresenter(httpRequest);
            }
        }

    }

    public HttpRequestPresenter(IHttpRequest httpRequest) {
        this.httpRequest = httpRequest;
    }

    @Override
    public void get(String url, Map<String, String> params, ICallback callback) {
        httpRequest.get(url, params, callback);
    }

    @Override
    public void post(String url, Map<String, String> params, ICallback callback) {
        httpRequest.get(url, params, callback);
    }
}
