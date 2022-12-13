package ru.vladimirkokourov.weather_app.service;

import ru.vladimirkokourov.weather_app.model.Forecast;

import java.io.IOException;

public interface ForecastService {

    Forecast getByKey(int key) throws IOException;

}
