package com.jinhu.lianxi_yuekao_20170430;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jinhu.lianxi_yuekao_20170430.fragment.MyFragment;
import com.jinhu.lianxi_yuekao_20170430.fragment.NewsFragment;

public class MainActivity extends FragmentActivity {

    private FrameLayout frame_layout;
    private RadioButton radio_btn_01;
    private RadioButton radio_btn_02;
    private RadioGroup radio_group;
    private FragmentManager mManager;
    private NewsFragment mNewsFragment;
    private MyFragment mMyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        initView();
        //
        initData();
    }

    private void initData() {
        mManager = getSupportFragmentManager();
        FragmentTransaction transaction = mManager.beginTransaction();
        mNewsFragment = new NewsFragment();
        mMyFragment = new MyFragment();
        transaction.add(R.id.frame_layout, mNewsFragment);
        transaction.add(R.id.frame_layout, mMyFragment);
        transaction.hide(mMyFragment);
        transaction.commit();
    }

    private void initView() {
        frame_layout = (FrameLayout) findViewById(R.id.frame_layout);
        radio_btn_01 = (RadioButton) findViewById(R.id.radio_btn_01);
        radio_btn_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = mManager.beginTransaction();
                transaction.show(mNewsFragment);
                transaction.hide(mMyFragment);
                transaction.commit();
            }
        });
        radio_btn_02 = (RadioButton) findViewById(R.id.radio_btn_02);
        radio_btn_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = mManager.beginTransaction();
                transaction.hide(mNewsFragment);
                transaction.show(mMyFragment);
                transaction.commit();
            }
        });
        radio_group = (RadioGroup) findViewById(R.id.radio_group);
    }
}
