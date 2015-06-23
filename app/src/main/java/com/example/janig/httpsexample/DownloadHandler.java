package com.example.janig.httpsexample;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Download resources from web page
 */
public class DownloadHandler {
    SmhiWatherDataInterface service;
    public DownloadHandler(MainActivity mainActivity) {
        Gson gson = new GsonBuilder().create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://opendata-download-metfcst.smhi.se")
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .build();

        service = restAdapter.create(SmhiWatherDataInterface.class);
    }


    public void downloadWeather(String longitude, String latitude, SmhiWeatherCallback callback) {
        service.getWeather(latitude,longitude,callback);
    }
}
