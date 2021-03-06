package com.example.monitorsensorsserver.service.impl;

import com.example.monitorsensorsserver.entity.Sensor;
import com.example.monitorsensorsserver.repository.SensorRepository;
import com.example.monitorsensorsserver.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Override
    public void save(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    @Override
    public void delete(Long id) {
        sensorRepository.deleteById(id);
    }

    @Override
    public String getDescription(String name) {
        return sensorRepository.getDescription(name);
    }

    @Override
    public List<Sensor> getAll() {
        return sensorRepository.findAll();
    }

    @Override
    public Sensor getById(Long id) {

        return sensorRepository.findById(id).get();
    }
}
