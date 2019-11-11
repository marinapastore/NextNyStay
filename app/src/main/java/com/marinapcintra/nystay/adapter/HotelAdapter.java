package com.marinapcintra.nystay.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.marinapcintra.nystay.R;
import com.marinapcintra.nystay.database.entity.Hotel;

import java.util.ArrayList;
import java.util.List;


public class HotelAdapter extends ArrayAdapter<Hotel> {


    public HotelAdapter(@NonNull Context context, List<Hotel> hotelsList) {
        super(context, 0, hotelsList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.hotel_row, parent, false);
        }

        TextView hotel_name = convertView.findViewById(R.id.hotel_name);
        TextView hotel_address = convertView.findViewById(R.id.hotel_address);
        RatingBar hotel_rating = convertView.findViewById(R.id.hotel_ratingBar);
        TextView hotel_lower_rate = convertView.findViewById(R.id.hotel_lower_rate);


        Hotel hotel = getItem(position);

        hotel_name.setText(hotel.getHotel_name());
        hotel_address.setText(hotel.getAddress());
        hotel_rating.setRating((float) hotel.getStars());
        hotel_rating.setMax(5);
        hotel_lower_rate.setText(String.format("R$ %.2f",hotel.getLower_rate()));


        return convertView;
    }
}
