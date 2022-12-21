package ru.vladimirkokourov.weather_app.service;

import ru.vladimirkokourov.weather_app.model.api.currentcondition.CurrentConditionRoot;

public interface CurrentConditionService {

    CurrentConditionRoot getByKey(final int locationKey);
}
