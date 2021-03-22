package com.example.monitorsensorsserver.repository;

import com.example.monitorsensorsserver.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SensorRepository extends JpaRepository<Sensor, Long> {
    @Query("SELECT s.description FROM sensors s WHERE s.name = :name")
    String getDescription(String name);

    @Query("SELECT s FROM sensors s " +
           "WHERE s.name LIKE :value " +
           "OR s.description LIKE :value " +
           "OR s.location LIKE :value " +
           "OR s.model LIKE :value")
    List<Sensor> getAll(String value);
}
