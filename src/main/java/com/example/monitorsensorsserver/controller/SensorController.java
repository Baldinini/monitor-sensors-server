package com.example.monitorsensorsserver.controller;

import com.example.monitorsensorsserver.entity.Sensor;
import com.example.monitorsensorsserver.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    private final SensorService sensorService;

    @Autowired
    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @PatchMapping
    public void create(Sensor sensor) {
        sensorService.save(sensor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sensorService.delete(id);
    }

}
