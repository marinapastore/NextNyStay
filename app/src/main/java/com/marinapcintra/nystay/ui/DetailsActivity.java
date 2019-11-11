package com.marinapcintra.nystay.ui;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.print.PrinterId;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.marinapcintra.nystay.R;
import com.marinapcintra.nystay.database.entity.Hotel;


public class DetailsActivity extends AppCompatActivity {

    private Hotel hotel_details;
    private TextView details_hotel_name;
    private TextView details_hotel_address;
    private TextView details_hotel_borough;
    private TextView details_hotel_price;
    private RatingBar details_ratingbar;

    @Override
        protected void onCreate (@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_page);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            hotel_details = (Hotel) getIntent().getSerializableExtra("chosen_hotel"); //Obtaining data
            System.out.println(hotel_details);
        }

        details_hotel_name = findViewById(R.id.details_hotel_name);
        details_hotel_address = findViewById(R.id.details_hotel_address);
        details_hotel_borough = findViewById(R.id.details_hotel_borough);
        details_hotel_price = findViewById(R.id.details_hotel_price);
        details_ratingbar = findViewById(R.id.details_ratingBar);

        details_hotel_name.setText(hotel_details.getHotel_name());
        details_hotel_address.setText(hotel_details.getBorough());
        details_hotel_borough.setText(hotel_details.getAddress());
        details_hotel_price.setText(String.format("R$ %.2f",hotel_details.getLower_rate()));
        details_ratingbar.setRating((float) hotel_details.getStars());
        //details_ratingbar.setMax(5);


        //Adicionando Back Button
            ActionBar actionBar = getSupportActionBar();
            if(actionBar != null){
                actionBar.setDisplayHomeAsUpEnabled(true);
            }

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    public void mapsCall(View view){
        Intent intent = new Intent(this, MapsActivity.class);

        intent.putExtra("lat_long",hotel_details.getLat()+","+hotel_details.getLog());

        startActivity(intent);
    }
}
