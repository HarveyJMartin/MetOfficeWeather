package training.metofficeweather.forecast;

import com.google.gson.annotations.SerializedName;
import training.metofficeweather.sitelist.Locations;

public class Root {

    @SerializedName(value="SiteRep")
    private SiteRep siteRep;

    public SiteRep getSiteRep() {
        return siteRep;
    }

    public void setSiteRep(SiteRep siteRep) {
        this.siteRep = siteRep;
    }



}
