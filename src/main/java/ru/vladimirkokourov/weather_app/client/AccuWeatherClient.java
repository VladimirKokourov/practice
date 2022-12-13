package ru.vladimirkokourov.weather_app.client;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class AccuWeatherClient {

    private static final String GET_TOP_CITIES = "http://dataservice.accuweather.com/currentconditions/v1/topcities/";
    private static final String GET_FORECAST = "http://dataservice.accuweather.com/forecasts/v1/daily/1day/";
    private static final String API_KEY = "?apikey=Q757XuxDIT6Itn4vJ6aFfKqAI8RBGCky";

    public String getTopCitiesJSON(int amountCity) throws IOException {

        String urlString = GET_TOP_CITIES + amountCity + API_KEY;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlString)
                .build();
        Response response = client.newCall(request).execute();

        return response.body().string();
    }

    public String getForecastJSON(int key) throws IOException {
        String urlString = GET_FORECAST + key + API_KEY;

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(urlString)
                .build();
        Response response = client.newCall(request).execute();

        String json = response.body().string();
        int indexBegin = json.indexOf('[');
        int indexEnd = json.lastIndexOf(']');

        return json.substring(indexBegin + 1, indexEnd);
    }
}
