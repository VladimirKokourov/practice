package ru.vladimirkokourov.weather_app.service;

import lombok.RequiredArgsConstructor;
import ru.vladimirkokourov.weather_app.client.AccuWeatherClient;
import ru.vladimirkokourov.weather_app.model.api.onedayforecast.DailyForecastRoot;

@RequiredArgsConstructor
public class ForecastServiceImpl implements ForecastService {

    private final AccuWeatherClient accuWeatherClient;

    @Override
    public DailyForecastRoot getByKey(final int locationKey) {
        return accuWeatherClient.get1DayForecast(locationKey);
    }
}
