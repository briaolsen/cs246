package com.example.a06prove;

// holds/returns the wind speed of a city
public class WeatherWind {

    private Float speed;

    public Float getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "" + speed;
    }
}
