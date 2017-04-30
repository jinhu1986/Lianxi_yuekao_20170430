package com.jinhu.lianxi_yuekao_20170430.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jinhu.lianxi_yuekao_20170430.R;
import com.jinhu.lianxi_yuekao_20170430.adapter.LvAdapter;
import com.jinhu.lianxi_yuekao_20170430.beans.JsonBean;
import com.jinhu.lianxi_yuekao_20170430.util.GsonUtils;
import com.jinhu.lianxi_yuekao_20170430.util.HttpUtils;
import com.jinhu.lianxi_yuekao_20170430.util.Url;
import com.jinhu.lianxi_yuekao_20170430.view.GlideImageLoader;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的用途：
 * Created by jinhu
 * 2017/4/30  10:19
 */

public class NewsFragment extends Fragment {

    private Banner mBanner;
    private ListView mListView;
    private List<JsonBean.ResultBean.BookListBean> mBookList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_news, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mBanner = (Banner) view.findViewById(R.id.banner);
        mListView = (ListView) view.findViewById(R.id.list_view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getServerData();
    }

    private void getServerData() {
        HttpUtils.getInstance().httpXUtilsGET(Url.ADD, null, new HttpUtils.MyCallback() {
            @Override
            public void onSuccess(String result) {
                JsonBean jsonBean = GsonUtils.gsonToBean(result, JsonBean.class);
                mBookList = jsonBean.getResult().getBookList();
                //

            }

            @Override
            public void onError(String errorMsg) {

            }

            @Override
            public void onFinished() {
                initBanner();
                initListView();
            }
        });
    }

    private void initListView() {
        LvAdapter adapter = new LvAdapter(mBookList, getActivity());
        mListView.setAdapter(adapter);
    }

    private void initBanner() {
        //设置图片加载器
        mBanner.setImageLoader(new GlideImageLoader());
        //图片集合
        List<String> images = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            images.add(mBookList.get(i).getCoverImg());
        }
        //设置图片集合
        mBanner.setImages(images);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
    }


}
