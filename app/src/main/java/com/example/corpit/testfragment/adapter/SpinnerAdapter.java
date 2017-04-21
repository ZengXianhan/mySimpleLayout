package com.example.corpit.testfragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.corpit.testfragment.R;
import com.example.corpit.testfragment.model.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by corpit on 21/4/2017.
 */

public class SpinnerAdapter extends BaseAdapter {
    Context context;
    List<Country> countryList = new ArrayList<>();
    LayoutInflater inflater;
    TextView countryName;
    ImageView countryFlag;

    public SpinnerAdapter(Context context, List<Country> countryList) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.countryList = countryList;
    }

    @Override
    public int getCount() {
        return countryList.size();
    }

    @Override
    public Object getItem(int position) {
        return countryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        try {
            convertView = inflater.inflate(R.layout.spinner_country,null);
            countryName = (TextView) convertView.findViewById(R.id.tv_countryName);
            countryFlag = (ImageView) convertView.findViewById(R.id.iv_countryflag);
            countryName.setText(countryList.get(position).countryName);
            countryFlag.setImageResource(countryList.get(position).countryFlag);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        return convertView;
    }
}
