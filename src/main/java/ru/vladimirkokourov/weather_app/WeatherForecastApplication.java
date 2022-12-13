package ru.vladimirkokourov.weather_app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import ru.vladimirkokourov.weather_app.client.AccuWeatherClient;
import ru.vladimirkokourov.weather_app.model.Forecast;
import ru.vladimirkokourov.weather_app.service.CityServiceImpl;
import ru.vladimirkokourov.weather_app.service.ForecastServiceImpl;

import java.io.IOException;
import java.util.Scanner;

public class WeatherForecastApplication {

    public static void main(String[] args) throws IOException {
        if (args[0] == null) {
            throw new IllegalArgumentException("plz enter apiKey as first arg!");
        }

        var okHttpClient = new OkHttpClient();
        var objectMapper = new ObjectMapper();
        var apiKey = args[0];

        var accuWeatherClient = new AccuWeatherClient(okHttpClient, objectMapper, apiKey);
        var cityService = new CityServiceImpl(accuWeatherClient);
        var forecastService = new ForecastServiceImpl(accuWeatherClient);
        var in = new Scanner(System.in);

        System.out.println("Input amount of cities(50, 100, 150): ");
        var amount = in.nextInt();
        var cityMap = cityService.getCityMap(amount);

        for (var nameCity : cityMap.keySet()) {
            System.out.println(nameCity);
        }

        while (true) {
            System.out.println("\nInput city or \"e\" for exit: ");
            var input = in.next();
            if (input.equals("e")) {
                return;
            }
            var key = cityMap.get(input);

            var forecast = forecastService.getByKey(key);
            System.out.printf("Forecast for %s: between %.0f and %.0f degrees Celsius.",
                    input, forecast.getMinTemperatureCelsius(), forecast.getMaxTemperatureCelsius());
        }
    }
}
