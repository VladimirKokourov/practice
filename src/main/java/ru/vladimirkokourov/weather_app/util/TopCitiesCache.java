package ru.vladimirkokourov.weather_app.util;

import ru.vladimirkokourov.weather_app.model.api.city.CityRoot;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopCitiesCache {
    private final Map<Integer, CityRoot> cache = new HashMap<>();

    public void addAll(final List<CityRoot> cityRoot) {
        System.out.println("Populating cache...");
        cityRoot.forEach(city ->
                cache.putIfAbsent(city.getKey(), city));
        System.out.println("Cache populated!");

    }

    public Map<Integer, CityRoot> getCache() {
        return Collections.unmodifiableMap(cache);
    }
}
