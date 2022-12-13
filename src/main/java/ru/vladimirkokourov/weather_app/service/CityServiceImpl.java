package ru.vladimirkokourov.weather_app.service;

import ru.vladimirkokourov.weather_app.client.AccuWeatherClient;
import ru.vladimirkokourov.weather_app.mapper.Mapper;

import java.io.IOException;
import java.util.Map;

public class CityServiceImpl implements CityService {

    private final AccuWeatherClient accuWeatherClient;
    private final Mapper mapper;

    public CityServiceImpl(AccuWeatherClient accuWeatherClient, Mapper mapper) {
        this.accuWeatherClient = accuWeatherClient;
        this.mapper = mapper;
    }

    @Override
    public Map<String, Integer> getCityMap(int amount) throws IOException {
        return mapper.toMap(accuWeatherClient.getTopCitiesJSON(amount));
    }
}
