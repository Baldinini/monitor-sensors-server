package com.example.monitorsensorsserver.service;

import com.example.monitorsensorsserver.entity.Sensor;

import java.util.List;

public interface SensorService {
    void save(Sensor sensor);

    void delete(Long id);

    List<Sensor> getAllByValue(String value);

    String getDescription(String name);

    List<Sensor> getAll();
}
