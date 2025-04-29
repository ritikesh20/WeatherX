package com.example.weatherx;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherx.model.WeatherResponse;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.listeners.OnClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewCityList;
    FastAdapter<WeatherXadapter> weatherXadapterFastAdapter;
    ItemAdapter<WeatherXadapter> itemAdapter;

    List<WeatherXadapter> weatherXadaptersList;

    EditText enterCityName;
    Button btnSearch;
    String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    String API_KEY = "d4f89a278f449917407116ed2c070315";
    Button btnCurrentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.btnSearch);
        enterCityName = findViewById(R.id.editCity);

        btnCurrentLocation = findViewById(R.id.btnCurrentLocation);

        btnCurrentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Yes Yesa", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerViewCityList = findViewById(R.id.recyclerViewCityList);
        recyclerViewCityList.setLayoutManager(new LinearLayoutManager(this));

        weatherXadapterFastAdapter = new FastAdapter<>();
        itemAdapter = new ItemAdapter<>();

        weatherXadapterFastAdapter = FastAdapter.with(itemAdapter);
        weatherXadaptersList = new ArrayList<>();

        recyclerViewCityList.setAdapter(weatherXadapterFastAdapter);

        ArrayList<String> list = new ArrayList<>();
        list.add("delhi");
        list.add("bhopal");
        list.add("goa");

        for (String topCityName : list) {
            cityReport(topCityName);
        }

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String etCityName = enterCityName.getText().toString().trim();
                if (!etCityName.isEmpty()) {
                    cityReport(etCityName);
                } else {
                    Toast.makeText(MainActivity.this, "enter City name or Pin Code", Toast.LENGTH_SHORT).show();
                }
            }
        });

        weatherXadapterFastAdapter.withOnClickListener(new OnClickListener<WeatherXadapter>() {
            @Override
            public boolean onClick(View v, @NonNull IAdapter<WeatherXadapter> adapter, @NonNull WeatherXadapter item, int position) {

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);

                intent.putExtra("cityName", item.weatherResponse.getName());
                intent.putExtra("cityTemp", item.weatherResponse.getMain().getTemp());
                intent.putExtra("cityMaxTemp", item.weatherResponse.getMain().getTemp_max());
                intent.putExtra("cityMinTemp", item.weatherResponse.getMain().getTemp_min());
                intent.putExtra("cityCondition", item.weatherResponse.getWeather().get(0).getDescription());
                intent.putExtra("cityPressure", item.weatherResponse.getMain().getPressure());

//                intent.putExtra("cityWind", item.weatherResponse.getWind().getSpeed());
                intent.putExtra("cityHumidity", item.weatherResponse.getMain().getHumidity());

                startActivity(intent);

                return true;
            }
        });
    }

    void cityReport(String cityName) {
        WeatherAPi weatherAPi = RetrofitClient.getClient(BASE_URL).create(WeatherAPi.class);
        Call<WeatherResponse> call = weatherAPi.getWeather(cityName, API_KEY, "metric");

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {

                if (response.isSuccessful() && response.body() != null) {

                    WeatherResponse weatherResponse = response.body();

                    String description = "";
                    if (weatherResponse.getWeather() != null && !weatherResponse.getWeather().isEmpty()) {
                        description = weatherResponse.getWeather().get(0).getDescription();
                    }

                    weatherXadaptersList.add(new WeatherXadapter(
                            weatherResponse.getName(),
                            weatherResponse.getMain().getTemp(),
                            weatherResponse.getMain().getTemp_max(),
                            weatherResponse.getMain().getTemp_min(),
                            description
                    ));

                    itemAdapter.set(weatherXadaptersList);


                } else {
                    Toast.makeText(MainActivity.this, "Moye Moye Moye", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Moye Moye", Toast.LENGTH_SHORT).show();
            }
        });
    }


}











/*
//        weatherXadapterFastAdapter.withOnClickListener(new OnClickListener<WeatherXadapter>() {
//            @Override
//            public boolean onClick(View v, IAdapter<WeatherXadapter> adapter, WeatherXadapter item, int position) {
//
//                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
//
//                intent.putExtra("cityName", item.weatherResponse.getName());
//                intent.putExtra("cityTemp", item.weatherResponse.getMain().getTemp());
//                intent.putExtra("cityMaxTemp", item.weatherResponse.getMain().getTemp_max());
//                intent.putExtra("cityMinTemp", item.weatherResponse.getMain().getTemp_min());
//                intent.putExtra("cityCondition", item.weatherResponse.getWeather().get(0).getDescription());
//
//                double xSpeed = 3.9;
//
//                //intent.putExtra("cityWind", item.weatherResponse.getWind().getSpeed());
//                intent.putExtra("cityWind", xSpeed);
////                Toast.makeText(MainActivity.this, "xwind" + item.weatherResponse.getWind().getSpeed(), Toast.LENGTH_SHORT).show();
////                intent.putExtra("cityDes", item.weatherResponse.getWind().getDeg());
////                intent.putExtra("cityGust", item.weatherResponse.getWind().getGust());
//
//                intent.putExtra("cityHumidity", item.weatherResponse.getMain().getHumidity());
//
//                startActivity(intent);
//                return true;
//            }
//        });

 */