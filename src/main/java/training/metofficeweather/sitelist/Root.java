package training.metofficeweather.sitelist;

import com.google.gson.annotations.SerializedName;
import training.metofficeweather.sitelist.Locations;

public class Root {
    @SerializedName(value="Locations")
    private Locations locations;

    public Locations getLocations() {
        return locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }



}
