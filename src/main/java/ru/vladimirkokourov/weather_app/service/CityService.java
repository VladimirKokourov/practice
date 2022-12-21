package ru.vladimirkokourov.weather_app.service;

import ru.vladimirkokourov.weather_app.model.api.enums.TopCityCount;

import java.io.IOException;
import java.util.Map;

public interface CityService {

    Map<String,Integer> getCityMap(final TopCityCount topCityCount);

}
