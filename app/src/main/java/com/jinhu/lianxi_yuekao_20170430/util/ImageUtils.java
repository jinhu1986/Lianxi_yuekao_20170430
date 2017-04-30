package com.jinhu.lianxi_yuekao_20170430.util;

import com.jinhu.lianxi_yuekao_20170430.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/4/30  11:20
 */

public class ImageUtils {
    public static DisplayImageOptions getOptions() {
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher_round)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .build();
        return options;
    }
}
