package com.yyy.proxyframeworkstudy.httpwork.okhttp;

import com.yyy.proxyframeworkstudy.httpwork.ICallback;

import java.io.IOException;
import java.util.Map;

import okhttp3.ResponseBody;

/**
 * Author ：you
 * Date ：2018/4/26
 * 用于：
 */
public interface IOkHttpReqeust {

    void getOkhttp(String url, Map<String, String> params, ICallback callback);

    void postOkhttp(String url, Map<String, String> params, ICallback callback);



}
