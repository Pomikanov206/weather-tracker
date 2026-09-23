package com.example.weather_tracker_backend.model;

import java.time.LocalDateTime;

public class Measurement {

    private Long id;

    private double latitude;
    private double longitude;

    private double temperature;
    private double humidity;

    private LocalDateTime createdAt;

    public Measurement() {
    }

    public Measurement(
            Long id,
            double latitude,
            double longitude,
            double temperature,
            double humidity,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.temperature = temperature;
        this.humidity = humidity;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}