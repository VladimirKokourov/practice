package ru.vladimirkokourov.weather_app.mapper;

import ru.vladimirkokourov.weather_app.model.api.currentcondition.CurrentConditionRoot;
import ru.vladimirkokourov.weather_app.model.api.onedayforecast.DailyForecastRoot;
import ru.vladimirkokourov.weather_app.model.dto.CityDTO;

public class Mapper {

    public CityDTO toDTO(final String name, final CurrentConditionRoot currentConditionRoot,
                         final DailyForecastRoot dailyForecastRoot) {

        var curTemperature = (int) currentConditionRoot.getTemperature().getMetric().getValue();

        var minTemperature = (int) ((dailyForecastRoot
                .getDailyForecasts()
                .get(0)
                .getTemperature()
                .getMinimum()
                .getValue() - 32) / 1.8);

        var maxTemperature = (int) ((dailyForecastRoot
                .getDailyForecasts()
                .get(0)
                .getTemperature()
                .getMaximum()
                .getValue() - 32) / 1.8);

        return new CityDTO(name, curTemperature, minTemperature, maxTemperature);
    }
}
