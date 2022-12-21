package ru.vladimirkokourov.weather_app.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.vladimirkokourov.weather_app.client.AccuWeatherClient;
import ru.vladimirkokourov.weather_app.model.api.onedayforecast.DailyForecastRoot;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ForecastServiceImplTest {

    private final AccuWeatherClient weatherClient = mock(AccuWeatherClient.class);
    private final ForecastService forecastService = new ForecastServiceImpl(weatherClient);

    @Test
    void getByKey_shouldBeSuccess() {
        var forecastRoot = new DailyForecastRoot();
        when(weatherClient.get1DayForecast(anyInt())).thenReturn(forecastRoot);

        var actual = forecastService.getByKey(anyInt());

        assertSame(forecastRoot, actual);
        verify(weatherClient).get1DayForecast(anyInt());
    }
}