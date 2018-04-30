package com.yyy.proxyframeworkstudy.httpwork;

/**
 * Author ：you
 * Date ：2018/4/24
 * 用于：请求结果回调。
 */
public interface ICallback {

    /**
     * 请求成功返回
     * @param result
     */
    void onSuccess(String result);

    /**
     * 失败返回
     * @param code
     * @param throwable
     */
    void onFailure(int code, Throwable throwable);
}
