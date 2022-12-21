package ru.vladimirkokourov.weather_app.service;

import ru.vladimirkokourov.weather_app.model.api.currentcondition.CurrentConditionRoot;
import ru.vladimirkokourov.weather_app.model.api.enums.TopCityCount;
import ru.vladimirkokourov.weather_app.model.api.onedayforecast.DailyForecastRoot;

public interface AccuWeatherService {
    int getLocationKey(TopCityCount topCityCount);

    CurrentConditionRoot getCurrentConditionRoot(TopCityCount topCityCount);

    DailyForecastRoot getDailyForecastRoot(TopCityCount topCityCount);
}
