package com.yyy.proxyframeworkstudy.httpwork;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yyy.proxyframeworkstudy.httpwork.ICallback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Author ：you
 * Date ：2018/4/24
 * 用于：
 */
public abstract class ModelCallback<T> implements ICallback {
    @Override
    public void onSuccess(String result) {
//        Type type = new TypeToken<T>(){}.getType();
//        T t = new Gson().fromJson(result, type);
        Class<? extends T> geneticClass = getGeneticClass(this);
        T t = new Gson().fromJson(result, geneticClass);
//        Log.e("modelcallback", result);
        onSuccessed(t);
    }

    protected Class<? extends T> getGeneticClass(Object object) {
        Type genericSuperclass = object.getClass().getGenericSuperclass();
        return (Class<? extends T>) ((ParameterizedType)genericSuperclass).getActualTypeArguments()[0];
    }

    protected abstract void onSuccessed(T t);
}
