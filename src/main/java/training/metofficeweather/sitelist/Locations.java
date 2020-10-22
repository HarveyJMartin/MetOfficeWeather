package training.metofficeweather.sitelist;

import com.google.gson.annotations.SerializedName;
import training.metofficeweather.sitelist.Location;

public class Locations {
    @SerializedName(value="Location")
    private Location[] location;

    public Location[] getLocation() {
        return location;
    }

    public void setLocation(Location[] location) {
        this.location = location;
    }


}
