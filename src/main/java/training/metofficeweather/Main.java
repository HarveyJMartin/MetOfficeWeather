package training.metofficeweather;

import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import training.metofficeweather.forecast.DV;
import training.metofficeweather.forecast.Period;
import training.metofficeweather.forecast.Rep;
import training.metofficeweather.forecast.SiteRep;
import training.metofficeweather.sitelist.Location;
import training.metofficeweather.sitelist.Locations;
import training.metofficeweather.sitelist.Root;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;


public class Main {
    public static void main(String args[]) throws IOException {
        Client client = ClientBuilder.newClient();
        String json = client.target("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=aa34d441-b333-4a68-abd8-4904d5971cfb")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);

        Gson gson = new Gson();

        Root root = gson.fromJson(json, Root.class);
        Locations locations = root.getLocations();
        Location[] locationsLocations = locations.getLocation();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter an ID");
        String inputID = scan.nextLine();
        for (int i = 0; i < locationsLocations.length; i++) {
            if (inputID.equals(locationsLocations[i].getId())) {
                System.out.println("Location Name: " + locationsLocations[i].getName());
                System.out.println("Region: " + locationsLocations[i].getRegion());
                System.out.println("Auth Area: " + locationsLocations[i].getUnitaryAuthArea());
                System.out.println("Longitude: " + locationsLocations[i].getLongitude());
                System.out.println("Latitude: " + locationsLocations[i].getLatitude());
                System.out.println("Elevation: " + locationsLocations[i].getElevation());
                System.out.println("ID: " + locationsLocations[i].getId());
            }
        }
        System.out.println("Enter location ID");
        String locationID = scan.nextLine();
        String url = "http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/" + locationID + "?res=3hourly&key=aa34d441-b333-4a68-abd8-4904d5971cfb";
        String json1 = client.target(url)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        training.metofficeweather.forecast.Root root1 = gson.fromJson(json1, training.metofficeweather.forecast.Root.class);
        SiteRep siteRep = root1.getSiteRep();
        DV dv = siteRep.getdV();
        training.metofficeweather.forecast.Location location = dv.getLocation();
        Period[] period = location.getPeriod();
        Rep[] rep = period[0].getRep();
        System.out.println("Current Temperature :" + rep[0].getTemperature() + "℃");
        System.out.println("Temperature feels like :" + rep[0].getFeelsLike() + "℃");
        System.out.println("Weather Type :" + rep[0].getWeatherType());
        System.out.println("Max UV :" + rep[0].getMaxUV());
        System.out.println("Relative Humidity :" + rep[0].getRelativeHumidity() + "%");
        System.out.println("Precipitation Probability :" + rep[0].getPrecipitationProbability() + "%");
        System.out.println("Visibility :" + rep[0].getVisibility());
        System.out.println("Wind Direction :" + rep[0].getWindDirection());
        System.out.println("Wind Gust :" + rep[0].getWindGust());
        System.out.println("Wind Speed :" + rep[0].getWindSpeed() + "Mph");


    }
}

