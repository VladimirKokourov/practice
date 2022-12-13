package ru.vladimirkokourov.weather_app.service;

import ru.vladimirkokourov.weather_app.client.AccuWeatherClient;
import ru.vladimirkokourov.weather_app.mapper.Mapper;
import ru.vladimirkokourov.weather_app.model.Forecast;

import java.io.IOException;

public class ForecastServiceImpl implements ForecastService {

    private final AccuWeatherClient accuWeatherClient;
    private final Mapper mapper;

    public ForecastServiceImpl(AccuWeatherClient accuWeatherClient, Mapper mapper) {
        this.accuWeatherClient = accuWeatherClient;
        this.mapper = mapper;
    }

    @Override
    public Forecast getByKey(int key) throws IOException {
        return mapper.toForecast(accuWeatherClient.getForecastJSON(key));
    }
}
