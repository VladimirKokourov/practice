package ru.vladimirkokourov.weather_app.model.api.onedayforecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
public class Headline{
    @JsonProperty("EffectiveDate")
    private Date effectiveDate;
    @JsonProperty("EffectiveEpochDate")
    private int effectiveEpochDate;
    @JsonProperty("Severity")
    private int severity;
    @JsonProperty("Text")
    private String text;
    @JsonProperty("Category")
    private String category;
    @JsonProperty("EndDate")
    private Date endDate;
    @JsonProperty("EndEpochDate")
    private int endEpochDate;
    @JsonProperty("MobileLink")
    private String mobileLink;
    @JsonProperty("Link")
    private String link;
}