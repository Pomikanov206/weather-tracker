package com.example.weather_tracker_backend.controller;

import com.example.weather_tracker_backend.model.Measurement;
import com.example.weather_tracker_backend.service.MeasurementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/measurements")
@CrossOrigin(origins = "http://localhost:5173")
public class MeasurementController {

    private final MeasurementService measurementService;

    public MeasurementController(MeasurementService measurementService) {
        this.measurementService = measurementService;
    }

    @GetMapping
    public List<Measurement> getAll() {
        return measurementService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Measurement> getById(@PathVariable Long id) {

        Measurement measurement = measurementService.getById(id);

        if (measurement == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(measurement);
    }

    @PostMapping
    public Measurement add(@RequestBody Measurement measurement) {
        return measurementService.add(measurement);
    }
}
