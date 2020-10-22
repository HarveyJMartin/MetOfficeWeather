package training.metofficeweather.forecast;

import com.google.gson.annotations.SerializedName;

public class DV {

    @SerializedName(value="Location")
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


}
