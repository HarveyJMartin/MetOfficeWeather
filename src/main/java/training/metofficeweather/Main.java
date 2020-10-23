package training.metofficeweather;

import java.io.IOException;
import training.metofficeweather.forecast.*;
import training.metofficeweather.sitelist.SiteListClient;

public class Main {
    public static void main(String args[]) throws IOException {
        SiteListClient siteListClient = new SiteListClient();
        siteListClient.siteList();
        ForecastClient forecastClient = new ForecastClient();
        forecastClient.forecast();
    }
}