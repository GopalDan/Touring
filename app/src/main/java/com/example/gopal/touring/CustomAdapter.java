package com.example.gopal.touring;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Custom adapter for HotelActivity & Touring Activity
 */
public class CustomAdapter extends ArrayAdapter<Item> {

    public CustomAdapter(Context context, ArrayList<Item> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        View currentView = view;
        if (currentView == null) {
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.hotel_list_item, parent, false);
        }
        Item currentItem = getItem(position);

        ImageView imageiew = currentView.findViewById(R.id.item_image);
        imageiew.setImageResource(currentItem.getmItemImageResourceId());

        TextView textView = currentView.findViewById(R.id.item_text_info);
        textView.setText(currentItem.getmItemName());
        return currentView;
    }
}
