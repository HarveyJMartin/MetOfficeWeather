package training.metofficeweather.forecast;

import com.google.gson.annotations.SerializedName;

public class Rep {
    @SerializedName(value="F")
    private String feelsLike;
    @SerializedName(value="G")
    private String windGust;
    @SerializedName(value="H")
    private String relativeHumidity;
    @SerializedName(value="T")
    private String temperature;
    @SerializedName(value="V")
    private String visibility;
    @SerializedName(value="D")
    private String windDirection;
    @SerializedName(value="S")
    private String windSpeed;
    @SerializedName(value="U")
    private String maxUV;
    @SerializedName(value="W")
    private String weatherType;
    @SerializedName(value="Pp")
    private String precipitationProbability;

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getWindGust() {
        return windGust;
    }

    public void setWindGust(String windGust) {
        this.windGust = windGust;
    }

    public String getRelativeHumidity() {
        return relativeHumidity;
    }

    public void setRelativeHumidity(String relativeHumidity) {
        this.relativeHumidity = relativeHumidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getMaxUV() {
        return maxUV;
    }

    public void setMaxUV(String maxUV) {
        this.maxUV = maxUV;
    }

    public String getWeatherType() {
        return weatherType;
    }

    public void setWeatherType(String weatherType) {
        this.weatherType = weatherType;
    }

    public String getPrecipitationProbability() {
        return precipitationProbability;
    }

    public void setPrecipitationProbability(String precipitationProbability) {
        this.precipitationProbability = precipitationProbability;
    }


}
