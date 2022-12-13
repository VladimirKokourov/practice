package ru.vladimirkokourov.weather_app.model.api.city;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
public class CityRoot {
    @JsonProperty("Key")
    private int key;
    @JsonProperty("EnglishName")
    private String name;
}
