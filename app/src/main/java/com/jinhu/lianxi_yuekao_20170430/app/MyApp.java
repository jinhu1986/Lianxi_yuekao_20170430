package com.jinhu.lianxi_yuekao_20170430.app;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/4/30  10:31
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //xutils
        x.Ext.init(this);
        x.Ext.setDebug(true);
        //image
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .memoryCacheExtraOptions(480, 800)
                .build();
        ImageLoader.getInstance().init(configuration);
    }
}
