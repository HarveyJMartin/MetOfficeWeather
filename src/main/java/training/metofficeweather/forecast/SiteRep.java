package training.metofficeweather.forecast;

import com.google.gson.annotations.SerializedName;

public class SiteRep {

    @SerializedName(value="DV")
    private DV dV;


    public DV getdV() {
        return dV;
    }

    public void setdV(DV dV) {
        this.dV = dV;
    }



}
