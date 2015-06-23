package com.example.janig.httpsexample;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Parse class for weather data
 */
public class SmhiWeatherData
{
    @SerializedName("lon")
    @Expose
    final String longitude;

    @Expose final Timeseries[] timeseries;

    @Expose final String referenceTime;

    @SerializedName("lat")
    @Expose final String latitude;

    public SmhiWeatherData(String longitude, Timeseries[] timeseries, String referenceTime, String latitude) {
        this.longitude = longitude;
        this.timeseries = timeseries;
        this.referenceTime = referenceTime;
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer  = new StringBuffer();
        stringBuffer.append("\nlongitude:"+longitude);
        stringBuffer.append("\nlatitude:"+latitude);
        stringBuffer.append("\nreferenceTime"+referenceTime);

        for (Timeseries t : timeseries ){
            stringBuffer.append("\ntemperature:"+t.temperature);
            stringBuffer.append("\nprecipitationCategory:"+t.precipitationCategory);
            stringBuffer.append("\nvalidTime:"+t.validTime);
        }

        return stringBuffer.toString();

    }

    public class Timeseries
    {
        @SerializedName("gust")
        @Expose
		/* measure unit: m/s */
        final String windGust;

        @SerializedName("mcc")
        @Expose
		/* measure unit: 0-8 */
        final String meanCloudCover;

        @SerializedName("lcc")
        @Expose
		/* measure unit: 0-8 */
        final String lowCloudCover;

        @SerializedName("msl")
		/* measure unit: hPa */
        @Expose final String pressure;

        @SerializedName("ws")
        @Expose
        /* measure unit: m/s */
        final String windVelocity;

        @SerializedName("tcc")
        @Expose
        /* measure unit: 0-8 */
        final String totalCloudCoverage;

        @SerializedName("tstm")
        @Expose
        /* measure unit: 0-100% */
        final String probabilityThunderstorm;

        @SerializedName("vis")
        @Expose
        /* measure unit: km */
        final String visibility;

        @SerializedName("t")
        @Expose
        /* measure unit: Celsius */
        final String temperature;

        @SerializedName("pcat")
        @Expose
        /* measure unit: Category of precipitation precipitation, 0 no, 1 snow, 2 snow and rain, 3 rain, 4 drizzle, 5, freezing rain, 6 freezing drizzle */
        final String precipitationCategory;

        @SerializedName("r")
        @Expose
        /* measure unit: 0-100% */
        final String relativeHumidity;

        @Expose
        /* measure unit: */
        final String validTime;

        @SerializedName("hcc")
        @Expose
        /* measure unit: */
        final String hcc;

        @SerializedName("pis")
        @Expose
        /* measure unit: */
        final String pis;

        @SerializedName("pit")
        @Expose
        /* measure unit: */
        final String pit;

        @SerializedName("wd")
        @Expose
        /* measure unit: Degree */
        final String windDirection;

        public Timeseries(String windGust, String meanCloudCover, String lowCloudCover, String pressure, String windVelocity, String totalCloudCoverage, String probabilityThunderstorm, String visibility, String temperature, String precipitationCategory, String relativeHumidity, String validTime, String hcc, String pis, String pit, String wd) {
            this.windGust = windGust;
            this.meanCloudCover = meanCloudCover;
            this.lowCloudCover = lowCloudCover;
            this.pressure = pressure;
            this.windVelocity = windVelocity;
            this.totalCloudCoverage = totalCloudCoverage;
            this.probabilityThunderstorm = probabilityThunderstorm;
            this.visibility = visibility;
            this.temperature = temperature;
            this.precipitationCategory = precipitationCategory;
            this.relativeHumidity = relativeHumidity;
            this.validTime = validTime;
            this.hcc = hcc;
            this.pis = pis;
            this.pit = pit;
            this.windDirection = wd;
        }
    }
}
