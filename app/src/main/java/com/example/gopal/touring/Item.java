package com.example.gopal.touring;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Property;

/**
 * Created by Gopal on 11/15/2018.
 */

public class Item {
    private String mItemName;
    private int mItemImageResourceId;
    private int mItemInfoResourceId;

    public Item(String itemName, int itemImageResourceId, int itemInfoResourceId) {
        mItemName = itemName;
        mItemImageResourceId = itemImageResourceId;
        mItemInfoResourceId = itemInfoResourceId;
    }

    public String getmItemName() {
        return mItemName;
    }

    public int getmItemImageResourceId() {
        return mItemImageResourceId;
    }

    public int getmItemInfoResourceId() {
        return mItemInfoResourceId;
    }

}
