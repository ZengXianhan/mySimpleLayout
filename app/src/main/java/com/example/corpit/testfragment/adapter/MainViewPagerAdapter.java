package com.example.corpit.testfragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.corpit.testfragment.fragment.FourPageFragment;
import com.example.corpit.testfragment.fragment.MainPageFragment;
import com.example.corpit.testfragment.fragment.SecondPageFragment;
import com.example.corpit.testfragment.fragment.ThirdPageFragment;

import java.util.List;

/**
 * Created by corpit on 3/4/2017.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new MainPageFragment();
            case 1:
                return new SecondPageFragment();
            case 2:
                return new ThirdPageFragment();
            case 3:
                return new FourPageFragment();
        }
        throw new IllegalStateException("No Fragment in position " + position);
    }

    @Override
    public int getCount() {
        return 4;
    }
}
