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
 * Custom adapter for ShoppingMall Activity
 */


public class CustomShopingAdapter extends ArrayAdapter<Item> {

    public CustomShopingAdapter(Context context, ArrayList<Item> arrayList) {
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        View currentView = view;
        if (currentView == null) {
            currentView = LayoutInflater.from(getContext()).inflate(R.layout.shopping_list_item, parent, false);
        }
        Item currentItem = getItem(position);

        TextView textView = currentView.findViewById(R.id.mall_name);
        textView.setText(currentItem.getmItemName());
        TextView textView1 = currentView.findViewById(R.id.mall_location);
        textView1.setText(currentItem.getmItemInfoResourceId());

        ImageView imageiew = currentView.findViewById(R.id.mall_image);
        imageiew.setImageResource(currentItem.getmItemImageResourceId());

        return currentView;
    }
}