package training.metofficeweather.sitelist;

import java.io.IOException;
import java.util.Scanner;

import com.google.gson.Gson;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class SiteListClient {


    public void siteList() {
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

    }
}