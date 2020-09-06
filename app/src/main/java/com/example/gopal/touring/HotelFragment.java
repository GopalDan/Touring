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
public class HotelFragment extends Fragment {
    private ArrayList<Item> mArrayList;

    public HotelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_list_view, container, false);

        mArrayList = new ArrayList<>();
        mArrayList.add(new Item(getString(R.string.itc_sonar), R.drawable.hotel_itc, R.string.info_hotel_itc));
        mArrayList.add(new Item(getString(R.string.the_gateway), R.drawable.hotel_gateway, R.string.info_hotel_gateway));
        mArrayList.add(new Item(getString(R.string.oberoi_grand), R.drawable.hotel_oberoi, R.string.info_hotel_oberoi));
        mArrayList.add(new Item(getString(R.string.novotel), R.drawable.hotel_novotel, R.string.info_hotel_novotel));
        mArrayList.add(new Item(getString(R.string.taj_bengal), R.drawable.hotel_taj_bengal, R.string.info_hotel_taj_bengal));

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
                boolean isHotelActivity = true;

                Intent intent = new Intent(getActivity(), DetailsActivity.class);
               // if use bundle instead of intent put extra to send data getting nothing at DetailsFragment
               /* Bundle args = new Bundle();
                args.putString("itemName", itemName);
                args.putInt("itemInfoResourceId", itemInfoResourceId);
                args.putInt("itemImageResourceId", itemImageResourceId);
                args.putBoolean("hotelActivity", isHotelActivity);

                DetailsFragment df = new DetailsFragment ();
                df.setArguments(args);

                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, df)
                        .commit();*/

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
