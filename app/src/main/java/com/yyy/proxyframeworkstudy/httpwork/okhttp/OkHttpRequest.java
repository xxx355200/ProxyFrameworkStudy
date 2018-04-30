package com.yyy.proxyframeworkstudy.httpwork.okhttp;

import com.yyy.proxyframeworkstudy.httpwork.ICallback;
import com.yyy.proxyframeworkstudy.httpwork.IHttpRequest;

import java.io.IOException;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Author ：you
 * Date ：2018/4/26
 * 用于：
 */
public class OkHttpRequest implements IOkHttpReqeust {

    private OkHttpClient client;

    String get(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            return response.body().string();
        } else {
            throw new IOException("Unexpected code " + response);
        }
    }

    public OkHttpRequest() {
        this.client = new OkHttpClient();
    }

    @Override
    public void getOkhttp(String url, Map<String, String> params, final ICallback callback){
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

        final String newUrl = url;
        Request request = new Request.Builder().url(newUrl).build();
        Response response = null;
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onSuccess(response.body().string());
            }
        });

    }

    @Override
    public void postOkhttp(String url, Map<String, String> params, ICallback callback){


    }
}
