package ru.vladimirkokourov.weather_app;

import ru.vladimirkokourov.weather_app.client.AccuWeatherClient;
import ru.vladimirkokourov.weather_app.mapper.Mapper;
import ru.vladimirkokourov.weather_app.model.Forecast;
import ru.vladimirkokourov.weather_app.service.CityService;
import ru.vladimirkokourov.weather_app.service.CityServiceImpl;
import ru.vladimirkokourov.weather_app.service.ForecastService;
import ru.vladimirkokourov.weather_app.service.ForecastServiceImpl;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class WeatherForecastApplication {

    public static void main(String[] args) throws IOException {

        AccuWeatherClient accuWeatherClient = new AccuWeatherClient();
        Mapper mapper = new Mapper();
        CityService cityService = new CityServiceImpl(accuWeatherClient,mapper);
        ForecastService forecastService = new ForecastServiceImpl(accuWeatherClient, mapper);
        Scanner in = new Scanner(System.in);

        System.out.println("Input amount of cities(50, 100, 150): ");
        int amount = in.nextInt();
        Map<String,Integer> map = cityService.getCityMap(amount);

        for (String nameCity : map.keySet()) {
            System.out.println(nameCity);
        }

        while (true) {
            System.out.println("\nInput city or \"e\" for exit: ");
            String input = in.next();
            if (input.equals("e")) {
                return;
            }
            int key = map.get(input);

            Forecast forecast = forecastService.getByKey(key);
            System.out.printf("Forecast for %s: between %.0f and %.0f degrees Celsius.",
                    input, forecast.getMinTemperatureCelsius(), forecast.getMaxTemperatureCelsius());
        }
    }
}
