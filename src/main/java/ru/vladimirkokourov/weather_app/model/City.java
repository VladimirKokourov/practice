package ru.vladimirkokourov.weather_app.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class City {
    private int key;
    private String name;

    @JsonCreator
    public City(@JsonProperty("Key") int key,
                @JsonProperty("EnglishName") String name) {
        this.key = key;
        this.name = name;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "key=" + key +
                ", name='" + name + '\'' +
                '}';
    }
}
