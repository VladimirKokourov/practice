package ru.vladimirkokourov.weather_app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import ru.vladimirkokourov.weather_app.client.AccuWeatherClient;
import ru.vladimirkokourov.weather_app.model.api.enums.TopCityCount;
import ru.vladimirkokourov.weather_app.service.AccuWeatherServiceImpl;
import ru.vladimirkokourov.weather_app.util.TopCitiesCache;

import java.util.Map;
import java.util.Scanner;

public class WeatherForecastApplication {

    public static void main(String[] args) {
        Map<String, String> getenv = System.getenv();
        System.out.println(getenv);
        if (args[0] == null) {
            throw new IllegalArgumentException("plz enter apiKey as first arg!");
        }

        var apiKey = args[0];
        var okHttpClient = new OkHttpClient();
        var objectMapper = new ObjectMapper();

        var accuWeatherClient = new AccuWeatherClient(okHttpClient, objectMapper, apiKey);
        var scanner = new Scanner(System.in);
        var topCitiesCache = new TopCitiesCache();

        var accuWeatherService = new AccuWeatherServiceImpl(accuWeatherClient, topCitiesCache, scanner);

        System.out.println("Input amount of cities(50, 100, 150): ");
        var inputAmount = scanner.nextInt();

        var topCityCount = switch (inputAmount) {
            case 50 -> TopCityCount.FIFTY;
            case 100 -> TopCityCount.HUNDRED;
            case 150 -> TopCityCount.HUNDRED_FIFTY;
            default -> throw new IllegalArgumentException("Enter incorrect number.");
        };

        var dailyForecastRoot = accuWeatherService.getDailyForecastRoot(topCityCount);
        System.out.println(dailyForecastRoot);
        var currentConditionRoot = accuWeatherService.getCurrentConditionRoot(topCityCount);
        System.out.println(currentConditionRoot);
    }
}
