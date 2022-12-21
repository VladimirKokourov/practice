package ru.vladimirkokourov.weather_app.model.api.onedayforecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
public class DailyForecast {
    @JsonProperty("Date")
    private Date date;
    @JsonProperty("EpochDate")
    private int epochDate;
    @JsonProperty("Temperature")
    private Temperature temperature;
    @JsonProperty("Day")
    private Day day;
    @JsonProperty("Night")
    private Night night;
    @JsonProperty("Sources")
    private ArrayList<String> sources;
    @JsonProperty("MobileLink")
    private String mobileLink;
    @JsonProperty("Link")
    private String link;
}