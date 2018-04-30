package com.yyy.proxyframeworkstudy.httpwork;

import com.yyy.proxyframeworkstudy.httpwork.ICallback;

import java.util.Map;

/**
 * Author ：you
 * Date ：2018/4/24
 * 用于：
 */
public interface IHttpRequest {

    /**
     * get请求
     * @param url
     * @param params
     */
    void get(String url, Map<String, String> params, ICallback callback);

    /**
     * post请求
     * @param url
     * @param params
     */
    void post(String url, Map<String, String> params, ICallback callback);

}
