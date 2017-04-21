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

        Country en = new Country("USA", R.drawable.us,R.string.hello_world_en);
        Country cn = new Country("China",R.drawable.cn,R.string.hello_world_cn);
        Country fr = new Country("France",R.drawable.fr,R.string.hello_world_fr);
        Country gb = new Country("Great Britain",R.drawable.gb,R.string.hello_world_br);
        Country it = new Country("Italy",R.drawable.it,R.string.hello_world_it);
        Country jp = new Country("Japan",R.drawable.jp,R.string.hello_world_jp);
        Country kr = new Country("Korea",R.drawable.kr,R.string.hello_world_kr);
        Country ru = new Country("Russia",R.drawable.ru,R.string.hello_world_ru);

        data.add(en);
        data.add(cn);
        data.add(fr);
        data.add(gb);
        data.add(it);
        data.add(jp);
        data.add(kr);
        data.add(ru);

        return data;
    }
}
