package ru.vladimirkokourov.weather_app.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import ru.vladimirkokourov.weather_app.model.api.city.CityRoot;
import ru.vladimirkokourov.weather_app.model.api.currentcondition.CurrentConditionRoot;
import ru.vladimirkokourov.weather_app.model.api.enums.TopCityCount;
import ru.vladimirkokourov.weather_app.model.api.onedayforecast.DailyForecastRoot;
import ru.vladimirkokourov.weather_app.support.Constants;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class AccuWeatherClient {
    private static final TypeReference<List<CityRoot>> cityRootListTypeReference = new TypeReference<>() {
    };
    private static final TypeReference<DailyForecastRoot> dailyForecastRootTypeReference = new TypeReference<>() {
    };
    private static final TypeReference<CurrentConditionRoot[]> currentConditionRootTypeReference = new TypeReference<>() {
    };

    private final OkHttpClient client;
    private final ObjectMapper objectMapper;
    private final String apikey;

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

        return call(httpUrl, dailyForecastRootTypeReference);
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

        return call(httpUrl, currentConditionRootTypeReference)[0];
    }


    private <T> T call(HttpUrl httpUrl, TypeReference<T> tTypeReference) {
        var request = new Request.Builder()
                .url(httpUrl)
                .build();

        System.out.println("Sending rq..:" + request);
        Response execute;
        try {
            execute = client.newCall(request).execute();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        System.out.println("Receiving rs: " + execute);

        try (var responseBody = execute.body()) {
            var json = responseBody.string();
            System.out.println(json);
            return objectMapper.readValue(json, tTypeReference);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
