package training.metofficeweather.web;

import com.google.gson.Gson;
import training.metofficeweather.forecast.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class WeatherInfo {
    private final String locationId;
    private final String forecastData;
    private final String tempFeelsLike;
    private final String weatherType;
    public String getLocationId() {
        return locationId;

    }
    public void code() {

    }
    public WeatherInfo(String locationId, Rep rep) {
        this.locationId = locationId;
        this.forecastData = "Current Temperature :" + rep.getTemperature() + "℃";
        this.tempFeelsLike = "Temperature feels like :" + rep.getFeelsLike() + "℃";
        this.weatherType = "Weather Type : " + rep.getWeatherType();
    }




    public String getForecastData() {return forecastData;}
    public String getTempFeelsLike() {return tempFeelsLike;}
    public String getWeatherType() {return weatherType;}
//    public String main(String[] args) throws IOException {
//        System.out.println("Current Temperature :" + rep[0].getTemperature() + "℃");
//        System.out.println("Temperature feels like :" + rep[0].getFeelsLike() + "℃");
//        System.out.println("Weather Type :" + rep[0].getWeatherType());
//        System.out.println("Max UV :" + rep[0].getMaxUV());
//        System.out.println("Relative Humidity :" + rep[0].getRelativeHumidity() + "%");
//        System.out.println("Precipitation Probability :" + rep[0].getPrecipitationProbability() + "%");
//        System.out.println("Visibility :" + rep[0].getVisibility());
//        System.out.println("Wind Direction :" + rep[0].getWindDirection());
//        System.out.println("Wind Gust :" + rep[0].getWindGust());
//        System.out.println("Wind Speed :" + rep[0].getWindSpeed() + "Mph");



    }









