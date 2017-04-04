package com.example.corpit.testfragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.corpit.testfragment.fragment.FourPageFragment;
import com.example.corpit.testfragment.fragment.MainPageFragment;
import com.example.corpit.testfragment.fragment.SecondPageFragment;
import com.example.corpit.testfragment.fragment.ThirdPageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by corpit on 3/4/2017.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments.add(new MainPageFragment());
        fragments.add(new SecondPageFragment());
        fragments.add(new ThirdPageFragment());
        fragments.add(new FourPageFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }


    @Override
    public int getCount() {
        return fragments.size();
    }
}
