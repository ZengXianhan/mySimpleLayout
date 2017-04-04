package com.example.corpit.testfragment.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.corpit.testfragment.R;
import com.example.corpit.testfragment.adapter.MainViewPagerAdapter;

public class MainActivity extends FragmentActivity {
    private LinearLayout mToMainPage;
    private LinearLayout mToSecondPage;
    private LinearLayout mToThirdPage;
    private LinearLayout mToFourthPage;

    private ImageView imageMainPage;
    private ImageView imageSecondPage;
    private ImageView imageThirdPage;
    private ImageView imageFourthPage;

    private ViewPager viewPager;
    private MainViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();
    }

    //初始化所有控件
    private void initView() {
        mToMainPage = (LinearLayout) findViewById(R.id.id_ll_tab_main_page);
        mToSecondPage = (LinearLayout) findViewById(R.id.id_ll_tab_two_page);
        mToThirdPage = (LinearLayout) findViewById(R.id.id_ll_tab_third_page);
        mToFourthPage = (LinearLayout) findViewById(R.id.id_ll_tab_fourth_page);

        imageMainPage = (ImageView) findViewById(R.id.id_tab_main_page);
        imageSecondPage = (ImageView) findViewById(R.id.id_tab_second_page);
        imageThirdPage = (ImageView) findViewById(R.id.id_tab_third_page);
        imageFourthPage = (ImageView) findViewById(R.id.id_tab_fourth_page);

        viewPager = (ViewPager) findViewById(R.id.viewpager_container);
    }

    //初始化数据
    private void initData() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new MainViewPagerAdapter(fragmentManager);  //定义新FragmentPagerAdapter
        viewPager.setAdapter(adapter);

        int colorPressed = R.color.colorTitle;  //下方Tag按钮的显示颜色
        imageMainPage.setBackgroundResource(colorPressed);
    }

    //初始化控件事件
    private void initEvent() {
        //下方Tag按钮点击事件
        mToMainPage.setOnClickListener(new MyOnClickListener());
        mToSecondPage.setOnClickListener(new MyOnClickListener());
        mToThirdPage.setOnClickListener(new MyOnClickListener());
        mToFourthPage.setOnClickListener(new MyOnClickListener());

        //viewPager的滑动事件，左右滑动可切换不同Fragment
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                int colorPressed = R.color.colorTitle;
                switch (position) {
                    case 0:
                        resetBtnColorStatus();
                        imageMainPage.setBackgroundResource(colorPressed);
                        break;
                    case 1:
                        resetBtnColorStatus();
                        imageSecondPage.setBackgroundResource(colorPressed);
                        break;
                    case 2:
                        resetBtnColorStatus();
                        imageThirdPage.setBackgroundResource(colorPressed);
                        break;
                    case 3:
                        resetBtnColorStatus();
                        imageFourthPage.setBackgroundResource(colorPressed);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //自定义按钮监听方法
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

    //Fragment切换方法
    private void goToMainPageFragment() {
        viewPager.setCurrentItem(0);
    }
    private void goToSecondPageFragment() {
        viewPager.setCurrentItem(1);
    }
    private void goToThirdPageFragment() {
        viewPager.setCurrentItem(2);
    }
    private void goToFourthPageFragment() {
//        FragmentManager fm = getSupportFragmentManager();        // 开启Fragment事务
//        FragmentTransaction transaction = fm.beginTransaction();
//        if (mFourthPageFragment == null) {
//            mFourthPageFragment = new FourPageFragment();
//        }
//        transaction.replace(R.id.fragment_frame_layout, mFourthPageFragment);// 使用当前Fragment的布局替代id_content的控件
//        transaction.commit();
        viewPager.setCurrentItem(3);
    }

    //重置所有的按钮颜色
    private void resetBtnColorStatus() {
        int colorReset = R.color.colorNoColor;
        imageMainPage.setBackgroundResource(colorReset);
        imageSecondPage.setBackgroundResource(colorReset);
        imageThirdPage.setBackgroundResource(colorReset);
        imageFourthPage.setBackgroundResource(colorReset);
    }
}
