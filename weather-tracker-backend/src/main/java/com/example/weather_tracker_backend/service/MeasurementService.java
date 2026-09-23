package com.example.weather_tracker_backend.service;

import com.example.weather_tracker_backend.model.Measurement;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeasurementService {

    private final List<Measurement> measurements = new ArrayList<>();

    private long nextId = 1;

    public List<Measurement> getAll() {
        return measurements;
    }

    public Measurement getById(Long id) {
        return measurements.stream()
                .filter(measurement -> measurement.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Measurement add(Measurement measurement) {

        measurement.setId(nextId++);
        measurement.setCreatedAt(LocalDateTime.now());

        measurements.add(measurement);

        return measurement;
    }
}