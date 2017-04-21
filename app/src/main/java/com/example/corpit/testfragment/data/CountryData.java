package com.example.corpit.testfragment.data;

import com.example.corpit.testfragment.R;
import com.example.corpit.testfragment.model.Country;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

/**
 * Created by corpit on 21/4/2017.
 */

public class CountryData {
    public static List<Country> getCountryList(){
        List<Country> data = new ArrayList<>();

        Country a = new Country("USA", R.drawable.us);
        Country b = new Country("China",R.drawable.cn);
        Country c = new Country("France",R.drawable.fr);
        Country d = new Country("Great Britain",R.drawable.gb);
        Country e = new Country("Italy",R.drawable.it);

        data.add(a);
        data.add(b);
        data.add(c);
        data.add(d);
        data.add(e);

        return data;
    }
}
