package com.example.a06prove;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;
import java.util.Map;

// Contains the information for the weather forecast of a city
public class WeatherForecastItem {

    @SerializedName("dt")
    private String dt_txt;
    private WeatherWind wind;
    private List<WeatherDescription> weather;
    @SerializedName("main")
    private Map<String, Float> measurements;

    // returns the temperature of the city
    public float getTemp() {
        return measurements.get("temp");
    }

    // returns the windspeed of the city
    public float getWind() {
        return wind.getSpeed();
    }

    @Override
    public String toString() {
        Date time = new Date(Long.parseLong(dt_txt) * 1000);
        String stringWeather = "";
        int i;
        for(i = 0; i < weather.size() - 1; i++) {
            stringWeather += weather.get(i) + " ";
        }
        stringWeather += weather.get(i);

        return "Time: " + time + "; Temp: " + measurements.get("temp") + "\u00B0F; Wind Speed: " + wind + "; Conditions: " + stringWeather;
    }
}
