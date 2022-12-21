package ru.vladimirkokourov.weather_app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import ru.vladimirkokourov.weather_app.client.AccuWeatherClient;
import ru.vladimirkokourov.weather_app.mapper.Mapper;
import ru.vladimirkokourov.weather_app.model.api.enums.TopCityCount;
import ru.vladimirkokourov.weather_app.model.dto.CityDTO;
import ru.vladimirkokourov.weather_app.service.CityServiceImpl;
import ru.vladimirkokourov.weather_app.service.CurrentConditionServiceImpl;
import ru.vladimirkokourov.weather_app.service.ForecastServiceImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class WeatherForecastApplication {

    public static void main(String[] args) {
        if (args[0] == null) {
            throw new IllegalArgumentException("plz enter apiKey as first arg!");
        }

        var okHttpClient = new OkHttpClient();
        var objectMapper = new ObjectMapper();
        var apiKey = args[0];

        var accuWeatherClient = new AccuWeatherClient(okHttpClient, objectMapper, apiKey);
        var cityService = new CityServiceImpl(accuWeatherClient);
        var forecastService = new ForecastServiceImpl(accuWeatherClient);
        var currentConditionService = new CurrentConditionServiceImpl(accuWeatherClient);
        var mapper = new Mapper();
        var in = new Scanner(System.in);

        System.out.println("Input amount of cities(50, 100, 150): ");

        var inputAmount = in.nextInt();

        var topCityCount = switch (inputAmount) {
            case 50 -> TopCityCount.FIFTY;
            case 100 -> TopCityCount.HUNDRED;
            case 150 -> TopCityCount.HUNDRED_FIFTY;
            default -> throw new IllegalArgumentException("Enter incorrect number.");
        };

        var cityMap = cityService.getCityMap(topCityCount);

        for (var nameCity : cityMap.keySet()) {
            System.out.println(nameCity);
        }

        while (true) {
            System.out.println("\nInput city or \"e\" for exit: ");
            String input = in.next();
            if (input.equals("e")) {
                return;
            }
            var locationKey = cityMap.get(input);
            if (locationKey == null) {
                throw new IllegalArgumentException("Enter incorrect name of city.");
            }

            var forecast = forecastService.getByKey(locationKey);
            var curCondition = currentConditionService.getByKey(locationKey);
            var city = mapper.toDTO(input, curCondition, forecast);

            System.out.printf("It's %d degrees Celsius in %s today. Forecast %d to %d.\n",
                    city.getCurTemperature(), city.getName(), city.getMinTemperature(), city.getMaxTemperature());
        }
    }
}
