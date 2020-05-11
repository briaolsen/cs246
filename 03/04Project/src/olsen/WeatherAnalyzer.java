package olsen;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Uses OpenWeatherMap.org to display the current weather conditions and 5 day forecast of input city
// Also compares 5 input cities max temp and max wind speed of their 5 day forecasts

public class WeatherAnalyzer {


    // Displays the current Weather Conditions of a city from OpenWeatherMap.org
    public void displayWeatherConditions(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q="
                + city + "&appid=838104eafe6b7fe169f8a4e859ab7dfc&units=imperial";
        HTTPHelper httpHelper = new HTTPHelper();
        String data = httpHelper.readHTTP(url);
        Gson gson = new Gson();
        WeatherConditions weatherConditions = gson.fromJson(data, WeatherConditions.class);
        System.out.println(weatherConditions);
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

    // Displays the 5 day Weather Forecast of a city from OpenWeatherMap.org
    public void displayWeatherForecast(String city) {
        WeatherForecast weatherForecast = getWeatherForecast(city);
        System.out.println(weatherForecast);
    }

    // Compares the weather forecast of 5 input cities
    public void compareWeather() {
        // Create a list of 5 cities and their forecast
        List<WeatherForecast> forecasts = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Compare 5 cities");
        String city = "";
        for(int i = 1; i < 6; i++) {
            System.out.println("City " + i + ": ");
            city = scanner.nextLine();
            forecasts.add(getWeatherForecast(city));
        }
        // Compare the five cities
        WeatherComparison compare = new WeatherComparison(forecasts);
        System.out.println("Max Temperature Comparison");
        compare.sortByTemp();
        System.out.println("Max Wind Speed Comparison");
        compare.sortByWind();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a city for the current weather and 5 day forecast: ");
        String city = scanner.nextLine();
        WeatherAnalyzer weather = new WeatherAnalyzer();
        weather.displayWeatherConditions(city);
        weather.displayWeatherForecast(city);

        weather.compareWeather();
    }
}
