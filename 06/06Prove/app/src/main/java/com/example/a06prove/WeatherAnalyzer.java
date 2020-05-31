package com.example.a06prove;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Uses OpenWeatherMap.org to display the current weather conditions and 5 day forecast of input city
// Also compares 5 input cities max temp and max wind speed of their 5 day forecasts

public class WeatherAnalyzer {

    // Displays the current Weather Conditions of a city from OpenWeatherMap.org
    public WeatherConditions getWeatherConditions(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + city + "&appid=838104eafe6b7fe169f8a4e859ab7dfc&units=imperial";
        HTTPHelper httpHelper = new HTTPHelper();
        String data = httpHelper.readHTTP(url);
        Gson gson = new Gson();
        return gson.fromJson(data, WeatherConditions.class);
    }

    // Returns the 5 day forecast data from the OpenWeatherMap API of a city
    public WeatherForecast getWeatherForecast(String city) {
        String url = "https://api.openweathermap.org/data/2.5/forecast?q="
                + city + "&appid=838104eafe6b7fe169f8a4e859ab7dfc&units=imperial";
        HTTPHelper httpHelper = new HTTPHelper();
        String data = httpHelper.readHTTP(url);
        Gson gson = new Gson();
        return gson.fromJson(data, WeatherForecast.class);
    }

}
