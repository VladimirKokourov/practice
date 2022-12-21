package ru.vladimirkokourov.weather_app.model.api.onedayforecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
public class Day{
    @JsonProperty("Icon")
    private int icon;
    @JsonProperty("IconPhrase")
    private String iconPhrase;
    @JsonProperty("HasPrecipitation")
    private boolean hasPrecipitation;
}