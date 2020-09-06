package com.example.gopal.touring;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TouringFragment extends Fragment {
    private ArrayList<Item> mArrayList;


    public TouringFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_list_view, container, false);

        mArrayList = new ArrayList<>();
        mArrayList.add(new Item(getString(R.string.nicco_park), R.drawable.nicco_park_image, R.string.nicco_park_info));
        mArrayList.add(new Item(getString(R.string.science_city), R.drawable.science_city_image, R.string.science_city_info));
        mArrayList.add(new Item(getString(R.string.alipoor_zoo), R.drawable.alipoor_zoo_image, R.string.alipoor_zoo_info));
        mArrayList.add(new Item(getString(R.string.aquatica), R.drawable.aquatica_image, R.string.aquatica_info));
        mArrayList.add(new Item(getString(R.string.victoria_memorial), R.drawable.victoria_memorial_image, R.string.victoria_memorial_info));

        ListView listView = rootView.findViewById(R.id.list);
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), mArrayList);
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Item currentItem = mArrayList.get(i);
                String itemName = currentItem.getmItemName();
                int itemInfoResourceId = currentItem.getmItemInfoResourceId();
                int itemImageResourceId = currentItem.getmItemImageResourceId();
                boolean isHotelActivity = false;
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("itemName", itemName);
                intent.putExtra("itemInfoResourceId", itemInfoResourceId);
                intent.putExtra("itemImageResourceId", itemImageResourceId);
                intent.putExtra("hotelActivity", isHotelActivity);
                startActivity(intent);
            }
        });

        return rootView;

    }
}
