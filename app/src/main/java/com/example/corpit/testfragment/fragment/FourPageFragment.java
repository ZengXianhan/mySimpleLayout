package com.example.corpit.testfragment.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.example.corpit.testfragment.R;
import com.example.corpit.testfragment.adapter.SpinnerAdapter;
import com.example.corpit.testfragment.data.CountryData;
import com.example.corpit.testfragment.model.Country;

import java.util.List;

/**
 * Created by corpit on 3/4/2017.
 */

public class FourPageFragment extends Fragment {
    Spinner spinner;
    List<Country> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_page_four,container,false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void initView(){
        View parent =getView();
        spinner = (Spinner)parent.findViewById(R.id.spinner);
    }

    private void initData(){
        data = CountryData.getCountryList();
        SpinnerAdapter adapter = new SpinnerAdapter(getContext(),data);
        spinner.setAdapter(adapter);
    }
}
