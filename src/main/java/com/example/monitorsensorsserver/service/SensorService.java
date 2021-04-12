package com.example.monitorsensorsserver.service;

import com.example.monitorsensorsserver.entity.Sensor;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SensorService {
    void save(Sensor sensor);

    void delete(Long id);

    String getDescription(String name);

    List<Sensor> getAll(Pageable pageable);

    Sensor getById(Long id);
}
