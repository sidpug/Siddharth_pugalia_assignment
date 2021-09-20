package com.sidpug.siddharth_pugalia.ui.history;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sidpug.siddharth_pugalia.Adapter.DataListAdapter;
import com.sidpug.siddharth_pugalia.DB.DataContract.DataEntry;
import com.sidpug.siddharth_pugalia.DB.DataHelper;
import com.sidpug.siddharth_pugalia.R;
import com.sidpug.siddharth_pugalia.data.data_model;
import com.sidpug.siddharth_pugalia.databinding.FragmentHistoryBinding;

import java.util.ArrayList;

public class HistoryFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<data_model> dataArrayList;

    private DataHelper db_helper;

    private FragmentHistoryBinding binding;

    TextView emptyList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        emptyList = emptyList.findViewById(R.id.empty_text);

        dataArrayList = new ArrayList<>();

        db_helper = new DataHelper(getActivity());

        displayDatabaseInfo();

        binding = FragmentHistoryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = recyclerView.findViewById(R.id.db_data);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        myAdapter = new DataListAdapter(getActivity(), dataArrayList);
        recyclerView.setAdapter(myAdapter);

        return root;
    }

    private void displayDatabaseInfo() {
        Log.d("TAG", "displayDataBaseInfo()");

        // Create and/or open a database to read from it
        SQLiteDatabase db = db_helper.getReadableDatabase();

        Log.d("TAG", "displayDataBaseInfo()1");

        String[] projection = {
                DataEntry.COLUMN_TIME,
                DataEntry.COLUMN_LAT,
                DataEntry.COLUMN_LON,
                DataEntry.COLUMN_TEMP,
                DataEntry.COLUMN_WEATHER

        };

        Log.d("TAG", "displayDataBaseInfo()2");

        // The table to query
        // The columns to return
        // The columns for the WHERE clause
        // The values for the WHERE clause
        // Don't group the rows
        // Don't filter by row groups
        try (Cursor cursor = db.query(
                DataEntry.TABLE_NAME,   // The table to query
                projection,                          // The columns to return
                null,                        // The columns for the WHERE clause
                null,                     // The values for the WHERE clause
                null,                        // Don't group the rows
                null,                         // Don't filter by row groups
                null)) {
            // Figure out the index of each column
            int timeIndex = cursor.getColumnIndex(DataEntry.COLUMN_TIME);
            int latIndex = cursor.getColumnIndex(DataEntry.COLUMN_LAT);
            int lonIndex = cursor.getColumnIndex(DataEntry.COLUMN_LON);
            int tempIndex = cursor.getColumnIndex(DataEntry.COLUMN_TEMP);
            int weatherIndex = cursor.getColumnIndex(DataEntry.COLUMN_WEATHER);

            Log.d("TAG", "displayDataBaseInfo()3");

            // Iterate through all the returned rows in the cursor
            while (cursor.moveToNext()) {
                // Use that index to extract the String or Int value of the word
                // at the current row the cursor is on.
                String time = cursor.getString(timeIndex);
                int lat = cursor.getInt(latIndex);
                int lon = cursor.getInt(lonIndex);
                int Temp = cursor.getInt(tempIndex);
                String weather = cursor.getString(weatherIndex);


                //Log.d("TAG", "displayDataBaseInfo()4");

                // Display the values from each column of the current row in the cursor in the TextView
                dataArrayList.add(new data_model(time, lat, lon, Temp, weather));
            }
        }
        // Always close the cursor when you're done reading from it. This releases all its
        // resources and makes it invalid.

        if (dataArrayList.isEmpty()) {
            emptyList.setVisibility(View.VISIBLE);
        } else {
            emptyList.setVisibility(View.GONE);
        }
    }// The sort order

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}