package ru.vladimirkokourov.weather_app.service;

import java.io.IOException;
import java.util.Map;

public interface CityService {

    Map<String,Integer> getCityMap(int amount) throws IOException;

}
