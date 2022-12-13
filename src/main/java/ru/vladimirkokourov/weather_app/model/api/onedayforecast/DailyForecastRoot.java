package ru.vladimirkokourov.weather_app.model.api.onedayforecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
public class DailyForecastRoot {
    @JsonProperty("Headline")
    private Headline headline;
    @JsonProperty("DailyForecasts")
    private ArrayList<DailyForecast> dailyForecasts;

}
