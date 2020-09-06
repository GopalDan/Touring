package com.example.gopal.touring;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {


    public DetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_details, container, false);


        TextView overViewText = rootView.findViewById(R.id.over_view_text);
        ImageView imageView = rootView.findViewById(R.id.item_image);
        TextView textView = rootView.findViewById(R.id.item_text_info);

        //if use bundle then retrieving the data here
        /* Bundle bundle = this.getArguments();
         if(bundle!=null){
             String itemName = bundle.getString("itemName");
            int itemInfoResourceId = bundle.getInt("itemInfoResourceId");
            int itemImageResourceId = bundle.getInt("itemImageResourceId");
            boolean isHotelActivity = bundle.getBoolean("hotelActivity");
*/

        Intent intent = getActivity().getIntent();
        if (intent.getExtras() != null) {
            // Receiving data in case of intent
            String itemName = intent.getStringExtra("itemName");
            int itemInfoResourceId = intent.getIntExtra("itemInfoResourceId", 0);
            int itemImageResourceId = intent.getIntExtra("itemImageResourceId", 0);
            boolean isHotelActivity = intent.getBooleanExtra("hotelActivity", false);


            if (isHotelActivity) {
                overViewText.setText(R.string.hotel_details);
            } else {
                overViewText.setText(itemName + " " + getString(R.string.over_view));
            }

            imageView.setImageResource(itemImageResourceId);
            textView.setText(itemInfoResourceId);

        }

        return rootView;
    }
}
