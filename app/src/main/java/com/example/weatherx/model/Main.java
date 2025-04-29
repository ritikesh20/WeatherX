package com.example.weatherx.model;

import com.google.gson.annotations.SerializedName;

public class Main {
    private double temp;
    private int humidity;
    private double temp_min;
    private double temp_max;

    private int pressure;

    @SerializedName("feels_like")
    private double feels_like;

    public double getTemp() {
        return temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getFeels_like() {
        return feels_like;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public void setFeels_like(double feels_like) {
        this.feels_like = feels_like;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setTemp_min(double temp_min) {
        this.temp_min = temp_min;
    }

    public void setTemp_max(double temp_max) {
        this.temp_max = temp_max;
    }
}
