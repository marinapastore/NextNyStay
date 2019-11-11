package com.marinapcintra.nystay.service;

import android.content.Context;
import android.content.SharedPreferences;

import com.marinapcintra.nystay.database.AppDatabase;
import com.marinapcintra.nystay.database.entity.Hotel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import de.siegmar.fastcsv.reader.CsvParser;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;

import static com.marinapcintra.nystay.ui.MainActivity.IS_DATABASE_CREATED_CORRECTLY;

public class HotelService {


    private Context mContext;
    private final int HOTEL_NAME = 0;
    private final int ADDRESS = 1;
    private final int BOROUGH = 2;
    private final int UMT_X = 3;
    private final int UMT_Y = 4;
    private final int LAT = 5;
    private final int LONG = 6;
    private final int STARS = 7;
    private final int LOWER_RATE = 8;
    private final int FOOD_SCORE = 9;
    private final int FUN_SCORE = 10;
    private final int COFFEE_SCORE = 11;
    private final int BARS_SCORE = 12;
    private final int LANDMARKS_SCORE = 13;

    private final static String TAG = "hotelService";

    private SharedPreferences mSharedPreference;

    public HotelService(Context context, SharedPreferences sharedPreferences) {
        mContext = context;
        mSharedPreference = sharedPreferences;
    }

    public void createDatabaseTable() {
        readCSVFile();
    }

    private void readCSVFile() {
        if (mContext != null) {
            try {
                InputStream ins = mContext.getResources().openRawResource(
                        mContext.getResources().getIdentifier("database",
                                "raw", mContext.getPackageName()));
                BufferedReader readerInput = new BufferedReader(new InputStreamReader(ins));
                CsvReader csvReader = new CsvReader();
                csvReader.setFieldSeparator(';');

                try (CsvParser csvParser = csvReader.parse(readerInput)) {
                    CsvRow row;
                    csvParser.nextRow(); //ignoring the first line
                    Hotel hotel;
                    while ((row = csvParser.nextRow()) != null) {
                        hotel = new Hotel();

                        hotel.setHotel_name((row.getField(HOTEL_NAME)));
                        hotel.setAddress((row.getField(ADDRESS)));
                        hotel.setBorough((row.getField(BOROUGH)));
                        hotel.setUmt_x((row.getField(UMT_X)));
                        hotel.setUmt_y(row.getField(UMT_Y));
                        hotel.setLat((row.getField(LAT)));
                        hotel.setLog((row.getField(LONG)));
                        hotel.setStars((Double.parseDouble(row.getField(STARS))));
                        hotel.setLower_rate((Double.parseDouble(row.getField(LOWER_RATE))));
                        hotel.setFood_score(row.getField(FOOD_SCORE));
                        hotel.setFun_score(row.getField(FUN_SCORE));
                        hotel.setCoffee_score(row.getField(COFFEE_SCORE));
                        hotel.setBars_score(row.getField(BARS_SCORE));
                        hotel.setLandmarks_score(row.getField(LANDMARKS_SCORE));


                        //verificar se já existe um bairro com o id cadastrado
                        AppDatabase appDatabase = AppDatabase.getAppDatabase(mContext);

                        //salvando todos os hotels
                        appDatabase.hotelDao().insertAll(hotel);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mSharedPreference.edit().putBoolean(IS_DATABASE_CREATED_CORRECTLY, true).apply();
    }


}
