package ru.vladimirkokourov.weather_app.model.api.onedayforecast;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Maximum {
    @JsonProperty("Value")
    private int value;
    @JsonProperty("Unit")
    private String unit;
    @JsonProperty("UnitType")
    private int unitType;
}
