package com.example.weatherx.model;

import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("sunrise")
    public long sunrise;

    @SerializedName("sunset")
    public long sunset;

    public long getSunrise() {
        return sunrise;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public void setSunset(long sunset) {
        this.sunset = sunset;
    }
}
