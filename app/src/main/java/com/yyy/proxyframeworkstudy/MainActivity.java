package com.yyy.proxyframeworkstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.yanzhenjie.nohttp.NoHttp;
import com.yyy.proxyframeworkstudy.httpwork.ModelCallback;
import com.yyy.proxyframeworkstudy.httpwork.okhttp.OKHttpRequestPresenter;
import com.yyy.proxyframeworkstudy.httpwork.okhttp.OkHttpRequest;
import com.yyy.proxyframeworkstudy.model.WeatherInfo;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        HttpRequestPresenter.init(new AsyncHttpRequest());
//        String url = "http://restapi.amap.com/v3/weather/weatherInfo";
//        Map<String, String> params = new HashMap<>();
//        params.put("city","宁德");
//        params.put("key","13cb58f5884f9749287abbead9c658f2");
//        HttpRequestPresenter.getInstance().get(url, params, new ModelCallback<WeatherInfo>() {
//            @Override
//            public void onFailure(int code, Throwable throwable) {
//                throwable.printStackTrace();
//            }
//
//            @Override
//            protected void onSuccessed(WeatherInfo weatherInfo) {
//                Log.e(TAG, "宁德的天气：" + weatherInfo.toString());
//            }
//        });

        OKHttpRequestPresenter.init(new OkHttpRequest());
        String url = "http://restapi.amap.com/v3/weather/weatherInfo";
        Map<String, String> params = new HashMap<>();
        params.put("city","宁德");
        params.put("key","13cb58f5884f9749287abbead9c658f2");
        OKHttpRequestPresenter.getInstance().getOkhttp(url, params, new ModelCallback<WeatherInfo>() {
            @Override
            public void onFailure(int code, Throwable throwable) {

            }

            @Override
            protected void onSuccessed(WeatherInfo weatherInfo) {
                Log.e(TAG, "宁德的天气：" + weatherInfo.toString());
            }
        });

        NoHttp.initialize(this);

    }
}
