package com.sidpug.siddharth_pugalia.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.sidpug.siddharth_pugalia.R;
import com.sidpug.siddharth_pugalia.data.data_model;

import java.util.ArrayList;

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.ViewHolder>{

    private final ArrayList<data_model> dataArrayList;

    public DataListAdapter(Context context, ArrayList<data_model> list) {
        dataArrayList = list;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView checked,latitude,longitude,temperature,weather;
        CardView cardView;
        LinearLayout dataset;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            checked = itemView.findViewById(R.id.time);
            latitude = itemView.findViewById(R.id.lat);
            longitude = itemView.findViewById(R.id.lon);
            temperature = itemView.findViewById(R.id.temp);
            weather = itemView.findViewById(R.id.weather);

            itemView.setOnClickListener(view -> {
                // still to be implemented
            });
        }
    }
    @NonNull
    @Override
    public DataListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from (viewGroup.getContext()).inflate(R.layout.data_list_item, viewGroup, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull DataListAdapter.ViewHolder viewHolder, int position) {
        viewHolder.itemView.setTag(dataArrayList.get(position));
        viewHolder.checked.setText(dataArrayList.get(position).getTime());
        viewHolder.latitude.setText(dataArrayList.get(position).getLat());
        viewHolder.longitude.setText(dataArrayList.get(position).getLon());
        viewHolder.temperature.setText(dataArrayList.get(position).getTemp());
        viewHolder.weather.setText(dataArrayList.get(position).getWeather());


    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }


}


