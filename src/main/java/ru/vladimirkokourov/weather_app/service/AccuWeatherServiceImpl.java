package ru.vladimirkokourov.weather_app.service;

import lombok.RequiredArgsConstructor;
import ru.vladimirkokourov.weather_app.client.AccuWeatherClient;
import ru.vladimirkokourov.weather_app.model.api.city.CityRoot;
import ru.vladimirkokourov.weather_app.model.api.currentcondition.CurrentConditionRoot;
import ru.vladimirkokourov.weather_app.model.api.enums.TopCityCount;
import ru.vladimirkokourov.weather_app.model.api.onedayforecast.DailyForecastRoot;
import ru.vladimirkokourov.weather_app.model.entity.CurrentConditionEntity;
import ru.vladimirkokourov.weather_app.util.TopCitiesCache;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class AccuWeatherServiceImpl implements AccuWeatherService {
    private final AccuWeatherClient accuWeatherClient;
    private final TopCitiesCache topCitiesCache;
    private final Scanner scanner;

    @Override
    public int getLocationKey(final TopCityCount topCityCount) {
        if (topCitiesCache.getCache().size() < topCityCount.getCount()) {
            List<CityRoot> topCities = accuWeatherClient.getTopCities(topCityCount);

            //List<CityEntity> cityEntityList = cityMapper.toCityEntity(topCities);

            topCitiesCache.addAll(topCities);
        } else {
            System.out.println("Top cities found in cache!");
        }

        var cityMap = topCitiesCache.getCache();
        cityMap.forEach((integer, cityRoot) -> System.out.println(cityRoot));

        System.out.println("\nPlz, Enter city key...: ");
        int cityKeyInput = scanner.nextInt();

        return cityMap.get(cityKeyInput).getKey();
    }

    @Override
    public CurrentConditionRoot getCurrentConditionRoot(final TopCityCount topCityCount) {
        var locationKey = getLocationKey(topCityCount);
        return accuWeatherClient.getCurrentCondition(locationKey);
    }

    @Override
    public DailyForecastRoot getDailyForecastRoot(final TopCityCount topCityCount) {
        var locationKey = getLocationKey(topCityCount);
        return accuWeatherClient.get1DayForecast(locationKey);
    }
}
