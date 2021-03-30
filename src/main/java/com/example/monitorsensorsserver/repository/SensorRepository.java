package com.example.monitorsensorsserver.repository;

import com.example.monitorsensorsserver.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

    @Query(value = "SELECT s.description FROM sensors s WHERE s.name = :name")
    String getDescription(String name);
}
