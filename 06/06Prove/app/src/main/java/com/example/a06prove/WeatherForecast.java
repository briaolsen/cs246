package com.example.a06prove;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


// Creates a weatherforecast object with a list of weatherforecastitems and the name of the city
public class WeatherForecast {

    private List<WeatherForecastItem> list;
    private WeatherCity city;

    // gets the name of the city
    public String getCity() {
        return city.getName();
    }

    // gets the max temperature in the 5 day forecast
    public float getMaxTemp() {
        List<Float> temps = new ArrayList<Float>();
        for(int i = 0; i < list.size(); i++) {
            temps.add(list.get(i).getTemp());
        }
        Collections.sort(temps);
        return temps.get(list.size() - 1);
    }

    // gets the max wind speed in the 5 day forecast
    public float getMaxWindSpeed() {
        List<Float> speeds = new ArrayList<Float>();
        for(int i = 0; i < list.size(); i++) {
            speeds.add(list.get(i).getWind());
        }
        Collections.sort(speeds);
        return speeds.get(list.size() - 1);
    }

    public ArrayList getForecast() {
        return new ArrayList<WeatherForecastItem>(list);
    }


    @Override
    public String toString() {
        String listString = "";
        for(int i = 0; i < list.size(); i++) {
            listString += list.get(i) + "\n";
        }
        return "Five day forecast: \n" + listString;
    }
}
