package ru.vladimirkokourov.weather_app.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.vladimirkokourov.weather_app.client.AccuWeatherClient;
import ru.vladimirkokourov.weather_app.model.api.city.CityRoot;
import ru.vladimirkokourov.weather_app.model.api.enums.TopCityCount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CityServiceImplTest {

    private final AccuWeatherClient accuWeatherClient = mock(AccuWeatherClient.class);
    private final CityService cityService = new CityServiceImpl(accuWeatherClient);

    @Test
    void getCityMap_shouldBeSuccess() {
        List<CityRoot> list = new ArrayList<>();
        CityRoot cityRoot = new CityRoot();
        cityRoot.setKey(1);
        cityRoot.setName("City");
        list.add(cityRoot);
        TopCityCount topCityCount = TopCityCount.FIFTY;
        when(accuWeatherClient.getTopCities(topCityCount)).thenReturn(list);

        Map<String,Integer> expected = new HashMap<>();
        expected.put("City", 1);

        Map<String,Integer> actual = cityService.getCityMap(topCityCount);

        assertEquals(expected, actual);
        verify(accuWeatherClient).getTopCities(topCityCount);
    }
}