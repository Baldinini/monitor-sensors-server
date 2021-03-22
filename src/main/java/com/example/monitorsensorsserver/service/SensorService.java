package com.example.monitorsensorsserver.service;

import com.example.monitorsensorsserver.entity.Sensor;

public interface SensorService {
    void save(Sensor sensor);

    void delete(Long id);

    String getDescription(String name);
}
