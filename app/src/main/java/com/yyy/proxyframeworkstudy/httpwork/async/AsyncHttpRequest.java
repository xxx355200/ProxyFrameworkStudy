package com.yyy.proxyframeworkstudy.httpwork.async;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.yyy.proxyframeworkstudy.httpwork.ICallback;
import com.yyy.proxyframeworkstudy.httpwork.IHttpRequest;

import java.util.Map;

/**
 * Author ：you
 * Date ：2018/4/24
 * 用于：
 */
public class AsyncHttpRequest implements IHttpRequest {

    private AsyncHttpClient asyncHttpClient;

    public AsyncHttpRequest() {
        asyncHttpClient = new AsyncHttpClient();
    }

    @Override
    public void get(String url, Map<String, String> params, final ICallback callback) {
        StringBuffer sb = new StringBuffer("?");
        if(null != params){
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append("&");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        url+=sb.toString();
        asyncHttpClient.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
                callback.onSuccess(new String(responseBody));
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
                callback.onFailure(statusCode, error);
            }
        });
    }

    @Override
    public void post(String url, Map<String, String> params, ICallback callback) {

    }
}
