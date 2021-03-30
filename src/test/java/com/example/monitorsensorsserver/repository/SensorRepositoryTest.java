package com.example.monitorsensorsserver.repository;

import com.example.monitorsensorsserver.entity.Sensor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class SensorRepositoryTest {

    @Autowired
    private SensorRepository sensorRepository;
    private Sensor sensor;

    @BeforeEach
    void setUp() {
        sensor = new Sensor();
        sensor.setName("Sensor 1");
        sensor.setModel("123qwe");
        sensor.setDescription("Sensor is working!");
        sensorRepository.save(sensor);
    }

    @Test
    void canGetDescription() {
        String description = sensorRepository.getDescription(sensor.getName());

        System.out.println(description);
        assertThat(description).isEqualTo(sensor.getDescription());
    }
}
