package com.example.corpit.testfragment.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.corpit.testfragment.R;
import com.example.corpit.testfragment.fragment.FourPageFragment;
import com.example.corpit.testfragment.fragment.MainPageFragment;
import com.example.corpit.testfragment.fragment.SecondPageFragment;
import com.example.corpit.testfragment.fragment.ThirdPageFragment;

public class MainActivity extends FragmentActivity {
    private LinearLayout mToMainPage;
    private LinearLayout mToSecondPage;
    private LinearLayout mToThirdPage;
    private LinearLayout mToFourthPage;

    private ImageView imageMainPage;
    private ImageView imageSecondPage;
    private ImageView imageThirdPage;
    private ImageView imageFourthPage;

    private Fragment mMainPageFragment;
    private Fragment mSecondPageFragment;
    private Fragment mThirdPageFragment;
    private Fragment mFourthPageFragment;
    private FrameLayout mFragmentFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        mToMainPage = (LinearLayout) findViewById(R.id.id_ll_tab_main_page);
        mToSecondPage = (LinearLayout) findViewById(R.id.id_ll_tab_two_page);
        mToThirdPage = (LinearLayout) findViewById(R.id.id_ll_tab_third_page);
        mToFourthPage = (LinearLayout) findViewById(R.id.id_ll_tab_fourth_page);

        imageMainPage = (ImageView) findViewById(R.id.id_tab_main_page);
        imageSecondPage = (ImageView) findViewById(R.id.id_tab_second_page);
        imageThirdPage = (ImageView) findViewById(R.id.id_tab_third_page);
        imageFourthPage = (ImageView) findViewById(R.id.id_tab_fourth_page);
    }

    private void initData() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        mMainPageFragment = new MainPageFragment();
        fragmentTransaction.replace(R.id.fragment_frame_layout, mMainPageFragment);
        fragmentTransaction.commit();
    }

    private void initEvent(){
        mToMainPage.setOnClickListener(new MyOnClickListener());
        mToSecondPage.setOnClickListener(new MyOnClickListener());
        mToThirdPage.setOnClickListener(new MyOnClickListener());
        mToFourthPage.setOnClickListener(new MyOnClickListener());
    }

    class MyOnClickListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            int colorPressed = R.color.colorTitle;
            switch (v.getId()) {
                case R.id.id_ll_tab_main_page:
                    goToMainPageFragment();
                    resetBtnColorStatus();
                    imageMainPage.setBackgroundResource(colorPressed);
                    break;
                case R.id.id_ll_tab_two_page:
                    goToSecondPageFragment();
                    resetBtnColorStatus();
                    imageSecondPage.setBackgroundResource(colorPressed);
                    break;
                case R.id.id_ll_tab_third_page:
                    goToThirdPageFragment();
                    resetBtnColorStatus();
                    imageThirdPage.setBackgroundResource(colorPressed);
                    break;
                case R.id.id_ll_tab_fourth_page:
                    goToFourthPageFragment();
                    resetBtnColorStatus();
                    imageFourthPage.setBackgroundResource(colorPressed);
                    break;
            }
        }
    }

    private void goToMainPageFragment(){
        FragmentManager fm = getFragmentManager();        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        if (mMainPageFragment == null) {
            mMainPageFragment = new MainPageFragment();
        }
        transaction.replace(R.id.fragment_frame_layout, mMainPageFragment);// 使用当前Fragment的布局替代id_content的控件
        transaction.commit();
    }

    private void goToSecondPageFragment(){
        FragmentManager fm = getFragmentManager();        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        if (mSecondPageFragment == null) {
            mSecondPageFragment = new SecondPageFragment();
        }
        transaction.replace(R.id.fragment_frame_layout, mSecondPageFragment);// 使用当前Fragment的布局替代id_content的控件
        transaction.commit();
    }

    private void goToThirdPageFragment(){
        FragmentManager fm = getFragmentManager();        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        if (mThirdPageFragment == null) {
            mThirdPageFragment = new ThirdPageFragment();
        }
        transaction.replace(R.id.fragment_frame_layout, mThirdPageFragment);// 使用当前Fragment的布局替代id_content的控件
        transaction.commit();
    }

    private void goToFourthPageFragment(){
        FragmentManager fm = getFragmentManager();        // 开启Fragment事务
        FragmentTransaction transaction = fm.beginTransaction();
        if (mFourthPageFragment == null) {
            mFourthPageFragment = new FourPageFragment();
        }
        transaction.replace(R.id.fragment_frame_layout, mFourthPageFragment);// 使用当前Fragment的布局替代id_content的控件
        transaction.commit();
    }

    private void resetBtnColorStatus(){
        int colorReset = R.color.colorNoColor;
        imageMainPage.setBackgroundResource(colorReset);
        imageSecondPage.setBackgroundResource(colorReset);
        imageThirdPage.setBackgroundResource(colorReset);
        imageFourthPage.setBackgroundResource(colorReset);
    }
}
