package ru.vladimirkokourov.weather_app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CityDTO {

    private String name;
    private int curTemperature;
    private int minTemperature;
    private int maxTemperature;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDTO cityDTO = (CityDTO) o;
        return curTemperature == cityDTO.curTemperature && minTemperature == cityDTO.minTemperature && maxTemperature == cityDTO.maxTemperature && Objects.equals(name, cityDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, curTemperature, minTemperature, maxTemperature);
    }
}
