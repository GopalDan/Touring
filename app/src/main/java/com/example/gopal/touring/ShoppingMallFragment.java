package com.example.gopal.touring;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingMallFragment extends Fragment {
    private ArrayList<Item> mArrayList;


    public ShoppingMallFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_list_view, container, false);


        mArrayList = new ArrayList<>();
        mArrayList.add(new Item(getString(R.string.salt_lake_city_centre), R.drawable.city_center_salt_lake, R.string.city_center_1_mall_location));
        mArrayList.add(new Item(getString(R.string.axis_mall), R.drawable.axis_mall, R.string.axis_mall_location));
        mArrayList.add(new Item(getString(R.string.acropolis_mall), R.drawable.acro_polis_mall, R.string.acropolis_mall_location));
        mArrayList.add(new Item(getString(R.string.city_center_2), R.drawable.city_center_2, R.string.city_center_2_mall_location));
        mArrayList.add(new Item(getString(R.string.south_city_mall), R.drawable.south_city_mall, R.string.south_city_mall_location));

        ListView listView = rootView.findViewById(R.id.list);
        CustomShopingAdapter customAdapter = new CustomShopingAdapter(getActivity(), mArrayList);
        listView.setAdapter(customAdapter);

        return rootView;

    }

}
