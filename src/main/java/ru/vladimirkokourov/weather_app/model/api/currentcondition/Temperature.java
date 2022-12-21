package ru.vladimirkokourov.weather_app.model.api.currentcondition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
public class Temperature {
    @JsonProperty("Metric")
    private Metric metric;
    @JsonProperty("Imperial")
    private Imperial imperial;
}
