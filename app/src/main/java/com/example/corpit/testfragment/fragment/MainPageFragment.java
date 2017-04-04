package com.example.corpit.testfragment.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.corpit.testfragment.R;

import java.util.zip.Inflater;

/**
 * Created by corpit on 3/4/2017.
 */

public class MainPageFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page_one,container,false);
    }
}
