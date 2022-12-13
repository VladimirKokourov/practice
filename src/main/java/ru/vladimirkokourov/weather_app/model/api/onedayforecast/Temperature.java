package ru.vladimirkokourov.weather_app.model.api.onedayforecast;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature{
    @JsonProperty("Minimum")
    public Minimum minimum;
    @JsonProperty("Maximum")
    public Maximum maximum;
}