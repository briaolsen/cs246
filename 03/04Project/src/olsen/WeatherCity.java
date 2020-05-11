package olsen;

// Contains the city name of a weather forecast item
public class WeatherCity {

    private String name;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "" + name;
    }
}
