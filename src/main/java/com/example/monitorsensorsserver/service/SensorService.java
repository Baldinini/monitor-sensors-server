package com.example.monitorsensorsserver.service;

import com.example.monitorsensorsserver.entity.Sensor;

import java.util.List;

public interface SensorService {
    void save(Sensor sensor);

    void delete(Long id);

    String getDescription(String name);

    List<Sensor> getAll();
}
