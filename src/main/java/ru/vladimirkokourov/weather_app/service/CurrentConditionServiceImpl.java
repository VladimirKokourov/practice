package ru.vladimirkokourov.weather_app.service;

import lombok.RequiredArgsConstructor;
import ru.vladimirkokourov.weather_app.client.AccuWeatherClient;
import ru.vladimirkokourov.weather_app.model.api.currentcondition.CurrentConditionRoot;

@RequiredArgsConstructor
public class CurrentConditionServiceImpl implements CurrentConditionService {

    public final AccuWeatherClient accuWeatherClient;

    @Override
    public CurrentConditionRoot getByKey(final int locationKey) {
        return accuWeatherClient.getCurrentCondition(locationKey);
    }
}
