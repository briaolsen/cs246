package olsen;

import java.util.*;

// Contains a list of weather forecasts
public class WeatherComparison {

    private List<WeatherForecast> list;

    public WeatherComparison(List<WeatherForecast> list) {
        this.list = list;
    }

    // Sorts and prints out the cities by highest temp in the next 5 days
    public void sortByTemp() {
        Map<Float, String> temps = new TreeMap<Float, String>();
        for(int i = 0; i < list.size(); i++) {
            temps.put(list.get(i).getMaxTemp(), list.get(i).getCity());
        }
        System.out.println(temps);
    }

    // Sorts and prints out the cities by highest wind speed in the next 5 days
    public void sortByWind() {
        Map<Float, String> speeds = new TreeMap<Float, String>();
        for(int i = 0; i < list.size(); i++) {
            speeds.put(list.get(i).getMaxWindSpeed(), list.get(i).getCity());
        }
        System.out.println(speeds);
    }

}
