package ru.vladimirkokourov.weather_app.mapper;

import org.junit.jupiter.api.Test;
import ru.vladimirkokourov.weather_app.model.api.currentcondition.CurrentConditionRoot;
import ru.vladimirkokourov.weather_app.model.api.currentcondition.Metric;
import ru.vladimirkokourov.weather_app.model.api.currentcondition.Temperature;
import ru.vladimirkokourov.weather_app.model.api.onedayforecast.DailyForecast;
import ru.vladimirkokourov.weather_app.model.api.onedayforecast.DailyForecastRoot;
import ru.vladimirkokourov.weather_app.model.api.onedayforecast.Maximum;
import ru.vladimirkokourov.weather_app.model.api.onedayforecast.Minimum;

import java.util.ArrayList;

class MapperTest {

    private final Mapper mapper = new Mapper();

    @Test
    void toDTO_shouldBeSuccess() {
        CityDTO expected = new CityDTO("Abc", 1, 2, 3);

        String name = "Abc";

        var metric = new Metric();
        var temperature = new Temperature();
        var curCondRoot = new CurrentConditionRoot();

        metric.setValue(1.0);
        temperature.setMetric(metric);
        curCondRoot.setTemperature(temperature);

        var minimum = new Minimum();
        var maximum = new Maximum();
        var temperatureMinMax = new ru.vladimirkokourov.weather_app.model.api.onedayforecast.Temperature();
        var dailyForecast = new DailyForecast();
        ArrayList<DailyForecast> list = new ArrayList<>();
        var dailyForecastRoot = new DailyForecastRoot();

        minimum.setValue(36);
        maximum.setValue(38);
        temperatureMinMax.setMinimum(minimum);
        temperatureMinMax.setMaximum(maximum);
        dailyForecast.setTemperature(temperatureMinMax);
        list.add(dailyForecast);
        dailyForecastRoot.setDailyForecasts(list);

        CityDTO actual = mapper.toDTO(name, curCondRoot, dailyForecastRoot);

        assertEquals(expected, actual);
    }
}