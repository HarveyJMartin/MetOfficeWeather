package training.metofficeweather.forecast;

import java.util.Scanner;
import com.google.gson.Gson;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

public class ForecastClient {
    public void forecast() {
        Client client = ClientBuilder.newClient();
        Gson gson = new Gson();
        System.out.println("Enter location ID");
        Scanner scan = new Scanner(System.in);
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
