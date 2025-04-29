package com.example.weatherx;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    TextView cityname, citytemp, citymintemp, citymaxtemp, citycondition,
            daymin, daymax, feelsLike, avgHH, avgAvg,
            citywindSpeed, citywindDeg, citywindGust,
            cityUVindex, citySunRiseTIme, citysunSetTime,
            cityPreMm, cityPreMMresutl, cityVisibilitykm, cityHumidity, citypressure;

    double cityXwindXspeed = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        cityname = findViewById(R.id.cityName);
        citytemp = findViewById(R.id.cityTemp);

        citymaxtemp = findViewById(R.id.cityMaxTemp);
        citymintemp = findViewById(R.id.cityMinTemp);
        feelsLike = findViewById(R.id.tvFeels_likeTemp);
        cityHumidity = findViewById(R.id.tvHumidty);

        citycondition = findViewById(R.id.cityWeatherConditions);

        daymin = findViewById(R.id.dayMin);
        daymax = findViewById(R.id.dayMax);

        avgHH = findViewById(R.id.avgHH);
        avgAvg = findViewById(R.id.avgAvg);

        citywindSpeed = findViewById(R.id.tvWindSpeed);
        citywindDeg = findViewById(R.id.tvDirection);
        citywindGust = findViewById(R.id.tvGust);

        citySunRiseTIme = findViewById(R.id.tvSunRiseTime);
        citysunSetTime = findViewById(R.id.tvSunSetTime);
        cityUVindex = findViewById(R.id.tvUVindex);


        cityPreMm = findViewById(R.id.tvPreMM);
        cityPreMMresutl = findViewById(R.id.tvPreMMResult);

        cityVisibilitykm = findViewById(R.id.tvVisibilityKM);


        citypressure = findViewById(R.id.cityPressure);

        Intent data = getIntent();


        String cityXname = data.getStringExtra("cityName");
        double cityXtemp = data.getDoubleExtra("cityTemp", 0.0);
        double cityXminTemp = data.getDoubleExtra("cityMinTemp", 0.0);
        double cityXmaxTemp = data.getDoubleExtra("cityMaxTemp", 0.0);
        String cityXcondition = data.getStringExtra("cityCondition");
        int cityXpressure = data.getIntExtra("cityPressure",0);


        cityname.setText(cityXname);
        citytemp.setText((int) cityXtemp + "°");
        citymaxtemp.setText(cityXmaxTemp + "°");
        citymintemp.setText(cityXminTemp + "°");
        citycondition.setText(cityXcondition);
        citypressure.setText(cityXpressure + "");

        //done

        double cityXdayMax = data.getDoubleExtra("cityMaxTemp", 0.0);
        double cityXdayMin = data.getDoubleExtra("cityMinTemp", 0.0);
        double cityXavgHH = data.getDoubleExtra("cityMaxTemp", 0.0);
        double cityXavgAvg = data.getDoubleExtra("cityMinTemp", 0.0);


        daymax.setText(cityXdayMax + "°");
        daymin.setText(cityXdayMin + "°");
        avgHH.setText(cityXavgHH + "°");
        avgAvg.setText(cityXavgAvg + "°");

        cityXwindXspeed = data.getDoubleExtra("x", 0.0);
        int cityXwindXdeg = data.getIntExtra("cityDeg", 0);
        double cityXwindXgust = data.getDoubleExtra("cityGust", 0.0);

//        citywindSpeed.setText(cityXwindXspeed + "kph");
//        citywindDeg.setText(cityXwindXdeg + "");
//        citywindGust.setText(cityXwindXgust + "SW");


        int cityXhumidity = data.getIntExtra("cityHumidity", 0);
        cityHumidity.setText(cityXhumidity + "");


    }
}

