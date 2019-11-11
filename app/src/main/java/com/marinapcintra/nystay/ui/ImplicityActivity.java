package com.marinapcintra.nystay.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.marinapcintra.nystay.R;
import com.marinapcintra.nystay.adapter.HotelAdapter;
import com.marinapcintra.nystay.database.AppDatabase;
import com.marinapcintra.nystay.database.entity.Hotel;
import com.marinapcintra.nystay.models.ClientChoicesModel;

import java.io.Serializable;
import java.util.List;


public class ImplicityActivity extends AppCompatActivity {

    private AppDatabase mAppDatabase;

    private ListView hotelsListView;

    private ClientChoicesModel clientChoicesModel;

    public String chosenCity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_page);

        clientChoicesModel = (ClientChoicesModel) getIntent().getSerializableExtra("clientChoicesModel");

        if(clientChoicesModel.isBronx()){
            this.chosenCity = "Bronx";
        }else if(clientChoicesModel.isBrooklyn()){
            this.chosenCity = "Brooklyn";
        }else{
            this.chosenCity = "New York";
        }

        //pegando instância do banco de dados
        mAppDatabase = AppDatabase.getAppDatabase(this);


        hotelsListView = findViewById(R.id.hotels_listView);

        List<Hotel> hotelsList = mAppDatabase.hotelDao().getHotelByParameters(this.chosenCity,clientChoicesModel.getStars(),clientChoicesModel.getPrice());

        List<Hotel> hotelsList2 = mAppDatabase.hotelDao().getHotelByParameters2(this.chosenCity);

        List<Hotel> hotelsList3 = mAppDatabase.hotelDao().getAll();


        HotelAdapter hotelAdapter = new HotelAdapter(this, hotelsList);

        hotelsListView.setAdapter(hotelAdapter);

        hotelsListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Hotel chosen_hotel = (Hotel) adapterView.getAdapter().getItem(i);
                System.out.println(chosen_hotel);
                detailsCall(chosen_hotel);
            }
        });

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


    public void detailsCall(Hotel hotel){
        Intent intent = new Intent(this, DetailsActivity.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("chosen_hotel",hotel);
        intent.putExtras(bundle);

        startActivity(intent);
    }


}
