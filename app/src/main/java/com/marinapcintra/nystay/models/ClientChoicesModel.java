package com.marinapcintra.nystay.models;

import java.io.Serializable;

public class ClientChoicesModel implements Serializable {

    public boolean favorites_coffee = false;

    public boolean favorites_arts = false;

    public boolean favorites_food = false;

    public boolean favorites_bars = false;

    public boolean favorites_landmarks = false;

    public double price = 0;

    public double stars = 0;

    public boolean bronx = false;

    public boolean brooklyn = false;

    public boolean manhatthan = false;

    public ClientChoicesModel(boolean favorites_coffee, boolean favorites_arts, boolean favorites_food, boolean favorites_bars, boolean favorites_landmarks, double price, double stars, boolean bronx, boolean brooklyn, boolean manhattan) {
        this.favorites_coffee = favorites_coffee;
        this.favorites_arts = favorites_arts;
        this.favorites_food = favorites_food;
        this.favorites_bars = favorites_bars;
        this.favorites_landmarks = favorites_landmarks;
        this.price = price;
        this.stars = stars;
        this.bronx = bronx;
        this.brooklyn = brooklyn;
        this.manhatthan = manhattan;
    }

    public boolean getFavorites_coffee() {
        return favorites_coffee;
    }

    public void setFavorites_coffee(boolean favorites_coffee) {
        this.favorites_coffee = favorites_coffee;
    }

    public boolean getFavorites_arts() {
        return favorites_arts;
    }

    public void setFavorites_arts(boolean favorites_arts) {
        this.favorites_arts = favorites_arts;
    }

    public boolean getFavorites_food() {
        return favorites_food;
    }

    public void setFavorites_food(boolean favorites_food) {
        this.favorites_food = favorites_food;
    }

    public boolean getFavorites() {
        return favorites_bars;
    }

    public void setFavorites(boolean favorites_bars) {
        this.favorites_bars = favorites_bars;
    }

    public boolean isFavorites_landmarks() {
        return favorites_landmarks;
    }

    public void setFavorites_landscapes(boolean favorites_landscapes) {
        this.favorites_landmarks = favorites_landscapes;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public boolean isBronx() {
        return bronx;
    }

    public void setBronx(boolean bronx) {
        this.bronx = bronx;
    }

    public boolean isBrooklyn() {
        return brooklyn;
    }

    public void setBrooklyn(boolean brooklyn) {
        this.brooklyn = brooklyn;
    }

    public boolean isManhatthan() {
        return manhatthan;
    }

    public void setManhatthan(boolean manhatthan) {
        this.manhatthan = manhatthan;
    }
}
