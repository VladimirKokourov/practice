package ru.vladimirkokourov.weather_app.model;

public class Forecast {

    private final double minTemperature;
    private final double maxTemperature;

    public Forecast(double minTemperature, double maxTemperature) {
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperatureFahrenheit() {
        return minTemperature;
    }

    public double getMaxTemperatureFahrenheit() {
        return maxTemperature;
    }

    public double getMinTemperatureCelsius() {
        return Math.ceil((minTemperature - 32) / 1.8);
    }

    public double getMaxTemperatureCelsius() {
        return Math.ceil((maxTemperature - 32) / 1.8);
    }
}
