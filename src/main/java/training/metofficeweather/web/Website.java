package training.metofficeweather.web;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import training.metofficeweather.forecast.DV;
import training.metofficeweather.forecast.Period;
import training.metofficeweather.forecast.Rep;
import training.metofficeweather.forecast.SiteRep;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@Controller
@EnableAutoConfiguration
public class Website {

    @RequestMapping("/")
    ModelAndView home() {
        return new ModelAndView("index");
    }

    @RequestMapping("/weatherInfo")
    ModelAndView weatherInfo(@RequestParam("locationId") String locationId) {
        Client client = ClientBuilder.newClient();
        Gson gson = new Gson();
        String url = "http://datapoint.metoffice.gov.uk/public/data/val/wxfcs/all/json/" + locationId + "?res=3hourly&key=aa34d441-b333-4a68-abd8-4904d5971cfb";
        String json1 = client.target(url)
                .request(MediaType.TEXT_PLAIN)
                .get(String.class);
        training.metofficeweather.forecast.Root root1 = gson.fromJson(json1, training.metofficeweather.forecast.Root.class);
        SiteRep siteRep = root1.getSiteRep();
        DV dv = siteRep.getdV();
        training.metofficeweather.forecast.Location location = dv.getLocation();
        Period[] period = location.getPeriod();
        Rep[] rep = period[0].getRep();
        return new ModelAndView("info", "weatherInfo", new WeatherInfo(locationId, rep[0])) ;

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Website.class, args);
    }

}