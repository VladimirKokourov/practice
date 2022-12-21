package ru.vladimirkokourov.weather_app.service;

import lombok.RequiredArgsConstructor;
import ru.vladimirkokourov.weather_app.client.AccuWeatherClient;
import ru.vladimirkokourov.weather_app.model.api.city.CityRoot;
import ru.vladimirkokourov.weather_app.model.api.enums.TopCityCount;

import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CityServiceImpl implements CityService {

    private final AccuWeatherClient accuWeatherClient;

    private String example;

    @Override
    public Map<String, Integer> getCityMap(final TopCityCount topCityCount) {
        var topCities = accuWeatherClient.getTopCities(topCityCount);

        return topCities.stream()
                .collect(Collectors.toMap(CityRoot::getName, CityRoot::getKey));
    }
}
