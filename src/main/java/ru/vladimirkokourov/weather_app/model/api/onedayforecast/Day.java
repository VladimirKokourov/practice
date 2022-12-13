package ru.vladimirkokourov.weather_app.model.api.onedayforecast;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Day{
    @JsonProperty("Icon")
    public int icon;
    @JsonProperty("IconPhrase")
    public String iconPhrase;
    @JsonProperty("HasPrecipitation")
    public boolean hasPrecipitation;
}