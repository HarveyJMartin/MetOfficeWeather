package training.metofficeweather.sitelist;

public class Location {
    private String elevation;
    private String id;
    private String latitude;
    private String longitude;
    private String name;
    private String region;
    private String unitaryAuthArea;

    public String getElevation() {
        return elevation;
    }

    public void setElevation(String elevation) {
        this.elevation = elevation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getUnitaryAuthArea() {
        return unitaryAuthArea;
    }

    public void setUnitaryAuthArea(String unitaryAuthArea) {
        this.unitaryAuthArea = unitaryAuthArea;
    }
}
