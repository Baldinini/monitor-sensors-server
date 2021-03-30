package com.example.monitorsensorsserver.service.impl;

import com.example.monitorsensorsserver.entity.Sensor;
import com.example.monitorsensorsserver.entity.Type;
import com.example.monitorsensorsserver.entity.Unit;
import com.example.monitorsensorsserver.repository.SensorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SensorServiceImplTest {

    @Mock
    private SensorRepository sensorRepository;
    private SensorServiceImpl sensorService;
    private Sensor sensor;

    @BeforeEach
    void setUp() {
        sensorService = new SensorServiceImpl(sensorRepository);
        sensor = new Sensor();
        sensor.setId(1L);
        sensor.setName("Sensor 10");
        sensor.setModel("123qwe");
        sensor.setType(new Type());
        sensor.setUnit(new Unit());
    }

    @Test
    void canSaveSensor() {
        sensorService.save(sensor);
        ArgumentCaptor<Sensor> argumentCaptor = ArgumentCaptor.forClass(Sensor.class);
        verify(sensorRepository).save(argumentCaptor.capture());
        System.out.println(argumentCaptor.getValue().toString());
        System.out.println(sensor.toString());
        assertThat(argumentCaptor.getValue()).isEqualTo(sensor);
    }

    @Test
    void canDeleteById() {
        Long id = 1L;
        sensorService.delete(id);
        ArgumentCaptor<Long> argumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(sensorRepository).deleteById(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isEqualTo(id);
    }
}
