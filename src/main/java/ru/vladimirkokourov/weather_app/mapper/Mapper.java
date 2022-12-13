package ru.vladimirkokourov.weather_app.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.vladimirkokourov.weather_app.model.City;
import ru.vladimirkokourov.weather_app.model.Forecast;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Mapper {

    public Map<String,Integer> toMap(String cityJson) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        List<City> cityList = objectMapper.readValue(cityJson, new TypeReference<>() {});

        return cityList.stream()
                .collect(Collectors.toMap(City::getName, City::getKey));
    }

    public Forecast toForecast(String forecastJson) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        double minTemperature = objectMapper
                .readTree(forecastJson)
                .at("/Temperature/Minimum/Value")
                .asDouble();
        double maxTemperature = objectMapper
                .readTree(forecastJson)
                .at("/Temperature/Maximum/Value")
                .asDouble();

        return new Forecast(minTemperature,maxTemperature);
    }
}
