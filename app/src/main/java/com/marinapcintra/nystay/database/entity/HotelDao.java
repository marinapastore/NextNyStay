package com.marinapcintra.nystay.database.entity;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface HotelDao {

    @Query("SELECT * FROM hotel")
    List<Hotel> getAll();

    @Query("SELECT * FROM hotel where address like :chosenBorough AND stars >= :chosenStars AND lower_rate <= :chosenLowerRate")
    List<Hotel> getHotelByParameters(String chosenBorough, double chosenStars, double chosenLowerRate);

    @Query("SELECT * FROM hotel where address like :chosenBorough")
    List<Hotel> getHotelByParameters2(String chosenBorough);


    @Insert
    void insertAll(Hotel... hotels);

    @Delete
    void delete(Hotel hotel);
}
