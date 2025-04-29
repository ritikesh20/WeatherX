package com.example.weatherx.model;

public class Wind {

    private double speed;
    private int deg;
    private double gust;


    public double getSpeed() {
        return speed;
    }

    public int getDeg() {
        return deg;
    }

    public double getGust() {
        return gust;
    }

    public void setGust(double gust) {
        this.gust = gust;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }
}

