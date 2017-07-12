package com.example.corpit.testfragment.activity;

import android.graphics.Color;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.corpit.testfragment.R;
import com.example.corpit.testfragment.adapter.MainViewPagerAdapter;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.MonitorNotifier;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

import java.util.Collection;

public class MainActivity extends FragmentActivity implements BeaconConsumer {
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

    private BeaconManager beaconManager;
    public static final String FILTER_UUID = "E2C56DB5-DFFB-48D2-B060-D0F5A71096E0";
    public static final String IBEACON_FORMAT ="m:2-3=0x0215,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25";
    protected static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        beaconManager = BeaconManager.getInstanceForApplication(getApplicationContext());
        // To detect proprietary beacons, you must add a line like below corresponding to your beacon
        // type.  Do a web search for "setBeaconLayout" to get the proper expression.
//        beaconManager.getBeaconParsers().add(new BeaconParser().
//                setBeaconLayout("m:2-3=beac,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25"));
        beaconManager.getBeaconParsers().add(new BeaconParser().
                setBeaconLayout(IBEACON_FORMAT));
        beaconManager.bind(this);
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

        int colorPressed = R.color.color_dark_gray;  //下方Tag按钮的显示颜色
        mToMainPage.setBackgroundResource(colorPressed);
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
                int colorPressed = R.color.color_dark_gray;
                switch (position) {
                    case 0:
                        resetBtnColorStatus();
                        mToMainPage.setBackgroundResource(colorPressed);
                        break;
                    case 1:
                        resetBtnColorStatus();
                        mToSecondPage.setBackgroundResource(colorPressed);
                        break;
                    case 2:
                        resetBtnColorStatus();
                        mToThirdPage.setBackgroundResource(colorPressed);
                        break;
                    case 3:
                        resetBtnColorStatus();
                        mToFourthPage.setBackgroundResource(colorPressed);
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
            int colorPressed = R.color.color_dark_gray;
            switch (v.getId()) {
                case R.id.id_ll_tab_main_page:
                    goToMainPageFragment();
                    resetBtnColorStatus();
                    mToMainPage.setBackgroundResource(colorPressed);
                    break;
                case R.id.id_ll_tab_two_page:
                    goToSecondPageFragment();
                    resetBtnColorStatus();

                    mToSecondPage.setBackgroundResource(colorPressed);
                    break;
                case R.id.id_ll_tab_third_page:
                    goToThirdPageFragment();
                    resetBtnColorStatus();
                    mToThirdPage.setBackgroundResource(colorPressed);
                    break;
                case R.id.id_ll_tab_fourth_page:
                    goToFourthPageFragment();
                    resetBtnColorStatus();
                    mToFourthPage.setBackgroundResource(colorPressed);
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
        mToMainPage.setBackgroundResource(colorReset);
        mToSecondPage.setBackgroundResource(colorReset);
        mToThirdPage.setBackgroundResource(colorReset);
        mToFourthPage.setBackgroundResource(colorReset);
    }

    @Override
    public void onBeaconServiceConnect() {
        Log.d(TAG, "connectedService");
        beaconManager.addMonitorNotifier(new MonitorNotifier() {
            @Override
            public void didEnterRegion(Region region) {
                Log.i(TAG, "I just saw an beacon for the first time!");
            }

            @Override
            public void didExitRegion(Region region) {
                Log.i(TAG, "I no longer see an beacon");
            }

            @Override
            public void didDetermineStateForRegion(int i, Region region) {
                Log.i(TAG, "I have just switched from seeing/not seeing beacons: " + i);
            }
        });
        try {
            beaconManager.startMonitoringBeaconsInRegion(new Region("myMonitoringUniqueId", null, null, null));
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        beaconManager.addRangeNotifier(new RangeNotifier() {
            @Override
            public void didRangeBeaconsInRegion(Collection<Beacon> collection, Region region) {
                Log.i("beacon size",  "beacon size = " + collection.size());
                if (collection.size() > 0) {
                    for (Beacon b :
                            collection) {
                        Log.i(TAG, "The "+ b.getBluetoothName() + " beacon I see about " + b.getDistance() + " meters away.");
                        Log.d("beaconTest", "distance: " +
                                b.getDistance() + "id: " +
                                b.getId1() + "/" +
                                b.getId2() + "/" +
                                b.getId3());
                    }

                }
            }
        });

        try {
            //开始监视
            beaconManager.startMonitoringBeaconsInRegion(new Region(FILTER_UUID, null, null, null));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        beaconManager = BeaconManager.getInstanceForApplication(getApplicationContext());
        // To detect proprietary beacons, you must add a line like below corresponding to your beacon
        // type.  Do a web search for "setBeaconLayout" to get the proper expression.
//        beaconManager.getBeaconParsers().add(new BeaconParser().
//                setBeaconLayout("m:2-3=beac,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25"));
        beaconManager.bind(this);
    }

    public static int colorSchemeConvert(String color){
        try {
            String alpha = color.substring(color.indexOf("/")+1,color.lastIndexOf(color)).trim();
            Integer alphaInt = Math.round( Float.valueOf(alpha) * 255);
            alpha = Integer.toHexString(alphaInt);

            String rgb = color.substring(0,5);
            String combineColor = "#" + alpha + rgb;
            int colorReturn = Color.parseColor(combineColor);
            return colorReturn;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return Color.WHITE;
        }
    }
}
