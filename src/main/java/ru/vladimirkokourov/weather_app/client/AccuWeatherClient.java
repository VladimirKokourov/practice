package ru.vladimirkokourov.weather_app.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import ru.vladimirkokourov.weather_app.mapper.Mapper;
import ru.vladimirkokourov.weather_app.model.api.city.CityRoot;
import ru.vladimirkokourov.weather_app.model.api.currentcondition.CurrentConditionRoot;
import ru.vladimirkokourov.weather_app.model.api.enums.TopCityCount;
import ru.vladimirkokourov.weather_app.model.api.onedayforecast.DailyForecastRoot;
import ru.vladimirkokourov.weather_app.support.Constants;

import java.io.IOException;
import java.util.List;

public class AccuWeatherClient {
    private static final TypeReference<List<CityRoot>> cityRootListTypeReference = new TypeReference<>() {
    };
    private static final TypeReference<DailyForecastRoot> dailyForecastRootTypeReference = new TypeReference<>() {
    };

    private final OkHttpClient client;
    private final ObjectMapper objectMapper;
    private final String apikey;

    public AccuWeatherClient(OkHttpClient client,
                             ObjectMapper objectMapper,
                             String apikey) {
        this.client = client;
        this.objectMapper = objectMapper;
        this.apikey = apikey;
    }

    public List<CityRoot> getTopCities(TopCityCount topCityCount) {
        var httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(Constants.ACCUWEATHER_HOST)
                .addPathSegment("currentconditions")
                .addPathSegment("v1")
                .addPathSegment("topcities")
                .addPathSegment(String.valueOf(topCityCount.getCount()))
                .addQueryParameter("apikey", apikey)
                .build();

        return call(httpUrl, cityRootListTypeReference);
    }

    public DailyForecastRoot get1DayForecast(int locationKey) {
        var httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(Constants.ACCUWEATHER_HOST)
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("1day")
                .addPathSegment(String.valueOf(locationKey))
                .addQueryParameter("apikey", apikey)
                .build();

        var request = new Request.Builder()
                .url(httpUrl)
                .build();

        try (var responseBody = client.newCall(request).execute().body()) {
            var json = responseBody.string();
            return objectMapper.readValue(json, DailyForecastRoot.class);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public CurrentConditionRoot getCurrentCondition(int locationKey) {
        var httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host(Constants.ACCUWEATHER_HOST)
                .addPathSegment("currentconditions")
                .addPathSegment("v1")
                .addPathSegment(String.valueOf(locationKey))
                .addQueryParameter("apikey", apikey)
                .build();

        var request = new Request.Builder()
                .url(httpUrl)
                .build();

        try (var responseBody = client.newCall(request).execute().body()) {
            var json = responseBody.string();
            CurrentConditionRoot[] arr = objectMapper.readValue(json, CurrentConditionRoot[].class);
            return arr[0];
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private <T> T call(HttpUrl httpUrl, TypeReference<T> tTypeReference) {
        var request = new Request.Builder()
                .url(httpUrl)
                .build();

        try (var responseBody = client.newCall(request).execute().body()) {
            var json = responseBody.string();
            return objectMapper.readValue(json, tTypeReference);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
