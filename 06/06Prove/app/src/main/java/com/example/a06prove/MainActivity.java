package com.example.a06prove;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText cityInput;
    private ListView listForecast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityInput = (EditText)findViewById(R.id.cityInput);
        listForecast = (ListView)findViewById(R.id.listForecast);
    }

    public void getTemp(View view) {
        Log.d("Weather Activity", "Getting Temperature for " + cityInput.getText().toString());
        TempThread tempThread = new TempThread(cityInput.getText().toString());
        tempThread.start();
    }

    public void displayTemp(String temp, String city) {

        Toast.makeText(this, "It is " + temp + " in " + city, Toast.LENGTH_LONG).show();
    }

    private class TempThread extends Thread {
        private String city;

        public TempThread(String city) {
            this.city = city;
        }

        @Override
        public void run() {
            WeatherAnalyzer weather = new WeatherAnalyzer();
            final WeatherConditions conditions = weather.getWeatherConditions(city);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    displayTemp(conditions.getTemp(), conditions.getCity());
                }
            });

        }
    }

    public void getForecast(View view) {
        ForecastThread forecastThread = new ForecastThread(cityInput.getText().toString());
        forecastThread.start();
    }

    public void displayForecast(WeatherForecast forecast) {
        ArrayAdapter<WeatherForecastItem> arrayAdapter = new ArrayAdapter<WeatherForecastItem>(this, android.R.layout.simple_list_item_1, forecast.getForecast());
        listForecast.setAdapter(arrayAdapter);
    }

    private class ForecastThread extends Thread {
        private String city;

        public ForecastThread(String city) {
            this.city = city;
        }

        @Override
        public void run() {
            WeatherAnalyzer weather = new WeatherAnalyzer();
            final WeatherForecast forecast = weather.getWeatherForecast(city);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    displayForecast(forecast);
                }
            });

        }
    }

}
