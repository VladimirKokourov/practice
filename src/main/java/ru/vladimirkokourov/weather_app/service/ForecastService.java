package ru.vladimirkokourov.weather_app.service;

import ru.vladimirkokourov.weather_app.model.api.onedayforecast.DailyForecastRoot;

public interface ForecastService {

    DailyForecastRoot getByKey(int locationKey);

}
