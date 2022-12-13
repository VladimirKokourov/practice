package ru.vladimirkokourov.weather_app.model.api.enums;

public enum TopCityCount {
    FIFTY(50),
    HUNDRED(100),
    HUNDRED_FIFTY(150);

    private final int count;

    TopCityCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
