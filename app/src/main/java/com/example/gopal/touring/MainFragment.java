package com.example.gopal.touring;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private DrawerLayout mDrawerLayout;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        //Set the toolbar as app bar
        Toolbar toolbar = rootView.findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        ActionBar actionbar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = rootView.findViewById(R.id.drawer_layout);

        NavigationView navigationView = rootView.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem item) {
                        // set item as selected to persist highlight
                        item.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        switch (item.getItemId()) {
                            case R.id.nav_how_to_reach:
                                Intent intent2 = new Intent(getActivity(), HowToReachActivity.class);
                                startActivity(intent2);
                                break;
                            case R.id.nav_places_to_visit:
                                Intent intent3 = new Intent(getActivity(), TouringActivity.class);
                                startActivity(intent3);
                                break;
                            case R.id.nav_shoppings_mall:
                                Intent intent4 = new Intent(getActivity(), ShoppingMallActivity.class);
                                startActivity(intent4);
                                break;
                            case R.id.nav_hotels:
                                Intent intent6 = new Intent(getActivity(), HotelActivity.class);
                                startActivity(intent6);
                                break;
                        }

                        return true;

                    }
                });
        return rootView;
    }

   //Here this method is not working
   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }*/

    //why it's showing override  super.onBackPresses() method
    // Here I want to show an alert dialog when user presses back button
/*    @Override
    public void onBackPressed() {

        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(R.string.exit_title);
        builder.setPositiveButton(R.string.positive_exit_action, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                getActivity().finish();

            }
        });
        builder.setNegativeButton(R.string.negative_exit_action, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Keep editing" button, so dismiss the dialog
                // and continue editing the pet.
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });

        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }*/

}


