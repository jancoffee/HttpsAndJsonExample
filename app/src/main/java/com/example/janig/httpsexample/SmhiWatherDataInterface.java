package com.example.janig.httpsexample;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Interface for define how to get current weather data from smhi
 */
public interface SmhiWatherDataInterface {
    @GET("/api/category/pmp2g/version/1/geopoint/lat/{latitude}/lon/{longitude}/data.json")
    void getWeather(@Path("latitude") String latitude,@Path("longitude") String longitude,SmhiWeatherCallback cb);
}
