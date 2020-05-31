package com.example.a06prove;

import java.util.Map;
import com.google.gson.annotations.SerializedName;

// Contains the weather conditions for a city
public class WeatherConditions {

    private int id;
    private String name;
    @SerializedName("main")
    private Map<String, Float> measurements;

    @Override
    public String toString() {

        return "The temperature in " + name + " is currently "
                + measurements.get("temp") + "\u00B0F";
    }

    public String getTemp() {
        return measurements.get("temp") + "\u00B0F";
    }

    public String getCity() {
        return name;
    }

}
