package com.marinapcintra.nystay.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "Hotel")
public class Hotel implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "hotel_name")
    private String hotel_name;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "borough")
    private String borough;

    @ColumnInfo(name = "umt_x")
    private String umt_x;

    @ColumnInfo(name = "umt_y")
    private String umt_y;

    @ColumnInfo(name = "lat")
    private String lat;

    @ColumnInfo(name = "log")
    private String log;

    @ColumnInfo(name = "stars")
    private double stars;

    @ColumnInfo(name = "lower_rate")
    private double lower_rate;

    @ColumnInfo(name = "food_score")
    private String food_score;

    @ColumnInfo(name = "fun_score")
    private String fun_score;

    @ColumnInfo(name = "coffee_score")
    private String coffee_score;

    @ColumnInfo(name = "bars_score")
    private String bars_score;

    @ColumnInfo(name = "landmarks_score")
    private String landmarks_score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBorough() {
        return borough;
    }

    public void setBorough(String borough) {
        this.borough = borough;
    }

    public String getUmt_x() {
        return umt_x;
    }

    public void setUmt_x(String umt_x) {
        this.umt_x = umt_x;
    }

    public String getUmt_y() {
        return umt_y;
    }

    public void setUmt_y(String umt_y) {
        this.umt_y = umt_y;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public double getLower_rate() {
        return lower_rate;
    }

    public void setLower_rate(double lower_rate) {
        this.lower_rate = lower_rate;
    }

    public String getFood_score() {
        return food_score;
    }

    public void setFood_score(String food_score) {
        this.food_score = food_score;
    }

    public String getFun_score() {
        return fun_score;
    }

    public void setFun_score(String fun_score) {
        this.fun_score = fun_score;
    }

    public String getCoffee_score() {
        return coffee_score;
    }

    public void setCoffee_score(String coffee_score) {
        this.coffee_score = coffee_score;
    }

    public String getBars_score() {
        return bars_score;
    }

    public void setBars_score(String bars_score) {
        this.bars_score = bars_score;
    }

    public String getLandmarks_score() {
        return landmarks_score;
    }

    public void setLandmarks_score(String landmarks_score) {
        this.landmarks_score = landmarks_score;
    }
}
