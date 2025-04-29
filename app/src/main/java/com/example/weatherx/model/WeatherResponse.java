package com.example.weatherx.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {

    private Main main;

    private String name;
    private Wind wind;
    private Clouds clouds;
    private List<Weather> weather;

    @SerializedName("sys")
    private Sys sys;

    public Main getMain() {
        return main;
    }

    public Sys getSys() {
        return sys;
    }

    public String getName() {
        return name;
    }

    public Wind getWind() {
        return wind;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

}
