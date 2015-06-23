package com.example.janig.httpsexample;

import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Retrofit callback when getting weather data from SMHI
 */
class SmhiWeatherCallback implements Callback<SmhiWeatherData> {
    private final String LOGTAG = "SmhiWeatherCallback";
    private Set<WeatherDataListener> listeners = null;

    SmhiWeatherCallback(){
        listeners = new HashSet<>();
    }

    public interface WeatherDataListener{
        void receivedWeatherData(SmhiWeatherData smhiWeatherData);
        void receivedError(String error);
    }

    public void addListener(WeatherDataListener listener){
        listeners.add(listener);
    }
    public void removeListener(WeatherDataListener listener){
        listeners.remove(listener);
    }

    @Override
    public void success(SmhiWeatherData smhiWeatherData, Response response) {
        Log.d(LOGTAG, "success smhiWeatherData:"+smhiWeatherData.toString());

        for(WeatherDataListener listener : listeners){
            listener.receivedWeatherData(smhiWeatherData);
        }

    }

    @Override
    public void failure(RetrofitError error) {
        Log.d(LOGTAG, "error:" + error);
        for (WeatherDataListener listener : listeners) {
            listener.receivedError("errorUrl:" + error.getUrl() + " errorResponse:" + error.getResponse());
        }
    }
}
