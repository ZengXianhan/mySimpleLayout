package com.example.corpit.testfragment.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

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
    TextView helloWorld;

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
        initEvent();
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
        helloWorld = (TextView) parent.findViewById(R.id.tv_helloWorld);
    }

    private void initData(){
        data = CountryData.getCountryList();
        SpinnerAdapter adapter = new SpinnerAdapter(getContext(),data);
        spinner.setAdapter(adapter);
        String sayHello = getResources().getString(data.get(0).helloWorld);
        helloWorld.setText(sayHello);
    }

    private void initEvent(){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sayHello = getResources().getString(data.get(position).helloWorld);
                helloWorld.setText(sayHello);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
