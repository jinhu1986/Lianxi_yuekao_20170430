package com.jinhu.lianxi_yuekao_20170430.util;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.HashMap;
import java.util.Map;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/4/30  10:32
 */

public class HttpUtils {
    private volatile static HttpUtils instance;

    /**
     * 单例模式
     *
     * @return
     */
    public static HttpUtils getInstance() {
        if (instance == null) {
            synchronized (HttpUtils.class) {
                if (instance == null) {
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    /**
     * xUtils post 请求方式
     *
     * @param url      get方式的网络路径
     * @param map      params 的 key ,values值
     * @param callback 接口回调
     */
    public void httpXUtilsGET(String url, HashMap<String, String> map, final MyCallback callback) {

        RequestParams params = new RequestParams(url);
        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                params.addQueryStringParameter(entry.getKey(), entry.getValue());
            }
        }
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                callback.onSuccess(result);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                callback.onError(ex.toString());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                callback.onFinished();
            }
        });

    }

    /**
     * 接口回调
     */
    public interface MyCallback {
        void onSuccess(String result);

        void onError(String errorMsg);

        void onFinished();
    }
}
