package training.metofficeweather;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;


public class Main {
    public static void main(String args[]) throws IOException {
        Client client = ClientBuilder.newClient();
        String json = client.target("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/sitelist?key=aa34d441-b333-4a68-abd8-4904d5971cfb")
        String json1 = client.target("http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/14?res=3hourly&key=aa34d441-b333-4a68-abd8-4904d5971cfb")
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
//        Gson gson = new Gson();
//        JsonReader reader = new JsonReader(new FileReader("NewMetOfficeAPIData.JSON"));
//        Review data = gson.fromJson(reader, Review.class);


        Gson gson =new Gson();

        Root root = gson.fromJson(json, Root.class);
        Locations locations = root.getLocations();
        Location[] locationsLocations = locations.getLocation();
        System.out.println("Location Name: " + locationsLocations[0].getName());
        System.out.println("Region: " + locationsLocations[0].getRegion());
        System.out.println("Auth Area: " + locationsLocations[0].getUnitaryAuthArea());
        System.out.println("Longitude: " + locationsLocations[0].getLongitude());
        System.out.println("Latitude: " + locationsLocations[0].getLatitude());
        System.out.println("Elevation: " + locationsLocations[0].getElevation());
        System.out.println("ID: " + locationsLocations[0].getId());

        Gson gson1 =new Gson();

        Root DV = gson1.fromJson(json1, Root.class);



    }
}	
