package com.sidpug.siddharth_pugalia.ui.maps;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.snackbar.Snackbar;
import com.sidpug.siddharth_pugalia.DB.DataHelper;
import com.sidpug.siddharth_pugalia.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MapsFragment extends Fragment  {

    Snackbar mySandbar;

    String date_and_time;

    private DataHelper db_helper;



    private final OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            googleMap.setOnMapClickListener(latLng -> {
                Log.e("clicked on map",""+ latLng.toString());
                googleMap.addMarker(new MarkerOptions().position(latLng).title("Mera area")
                        .snippet("Mai yahan ka raja hoon!"));
                get_weather(latLng);

            });
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy, hh:mm a");

        date_and_time = simpleDateFormat.format(calendar.getTime());


        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        mySandbar = Snackbar.make(view, R.string.app_name, Snackbar.LENGTH_LONG);
        }
    }

    void get_weather(LatLng latLng) {
        db_helper = new DataHelper(getActivity());
        String str = "lat/lng: (-20.78946169529182,140.25976561009887)".replaceAll("[lat/ng: ()]","");
        String[] arrOfStr = str.split(",", 2);

        String lat = arrOfStr[0];
        String lon = arrOfStr[1];
        //call api here

        String weather = "clear sky",temp = "41 Degree C";
        new DataHelper(getActivity()).insertTransferData(date_and_time,lat,lon,temp,weather);

    }


}