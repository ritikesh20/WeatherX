package com.example.weatherx;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.weatherx.model.Main;
import com.example.weatherx.model.Weather;
import com.example.weatherx.model.WeatherResponse;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.ArrayList;
import java.util.List;

public class WeatherXadapter extends AbstractItem<WeatherXadapter, WeatherXadapter.ViewHolder> {

    WeatherResponse weatherResponse;

    public WeatherXadapter(WeatherResponse weatherResponseList) {
        this.weatherResponse = weatherResponseList;
    }

    public WeatherXadapter(String cityName, double cityTemp, double minTemp, double maxTemp, String weatherCondition) {

        this.weatherResponse = new WeatherResponse();
        this.weatherResponse.setName(cityName);

        Main main = new Main();
        main.setTemp(cityTemp);
        main.setTemp_max(maxTemp);
        main.setTemp_min(minTemp);

        this.weatherResponse.setMain(main);

        Weather weather = new Weather();
        weather.setDescription(weatherCondition);

        List<Weather> weatherList = new ArrayList<>();

        weatherList.add(weather);
        this.weatherResponse.setWeather(weatherList);
    }

    @NonNull
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    @Override
    public int getType() {
        return R.id.cityXcount;
        //
    }

    @Override
    public int getLayoutRes() {
        return R.layout.city_list_ui;
    }


    public static class ViewHolder extends FastAdapter.ViewHolder<WeatherXadapter> {

        TextView tvCityName, tvTempWeather,
                tvMaxTempWeather, tvMinTempWeather, tvWeatherResult;

        public ViewHolder(View itemView) {
            super(itemView);
            tvCityName = itemView.findViewById(R.id.textViewCityWeather);
            tvTempWeather = itemView.findViewById(R.id.textViewTempWeather);
            tvMaxTempWeather = itemView.findViewById(R.id.textViewMaxTempWeather);
            tvMinTempWeather = itemView.findViewById(R.id.textViewMinTempWeather);
            tvWeatherResult = itemView.findViewById(R.id.textViewWeatherConditionWeather);

        }

        @Override
        public void bindView(WeatherXadapter item, List<Object> payloads) {

            tvCityName.setText(item.weatherResponse.getName());
            tvTempWeather.setText(String.valueOf((int) item.weatherResponse.getMain().getTemp()));
            tvMinTempWeather.setText(String.valueOf(item.weatherResponse.getMain().getTemp_min()));
            tvMinTempWeather.setText(String.valueOf(item.weatherResponse.getMain().getTemp_max()));

            String description = "";
            if (item.weatherResponse.getWeather() != null && !item.weatherResponse.getWeather().isEmpty()) {
                description = item.weatherResponse.getWeather().get(0).getDescription();
            }

            tvWeatherResult.setText(description);

        }

        @Override
        public void unbindView(WeatherXadapter item) {

            tvCityName.setText(null);
            tvTempWeather.setText(null);
            tvMinTempWeather.setText(null);
            tvMaxTempWeather.setText(null);
            tvWeatherResult.setText(null);

        }
    }
}
