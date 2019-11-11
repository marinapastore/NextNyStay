package com.marinapcintra.nystay.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.marinapcintra.nystay.database.entity.Hotel;
import com.marinapcintra.nystay.database.entity.HotelDao;

@Database(entities = {Hotel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;
    public abstract HotelDao hotelDao();

    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "squares")
                            .allowMainThreadQueries() //rodando na main apenas para facilitar o entendimento
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static void destroyInstance() {

        INSTANCE = null;
    }
}
