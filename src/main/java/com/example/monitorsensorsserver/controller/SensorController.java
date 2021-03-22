package com.example.monitorsensorsserver.controller;

import com.example.monitorsensorsserver.dto.request.SensorRequestDto;
import com.example.monitorsensorsserver.dto.response.SensorResponseDto;
import com.example.monitorsensorsserver.entity.Sensor;
import com.example.monitorsensorsserver.mapper.SensorMapper;
import com.example.monitorsensorsserver.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sensors")
public class SensorController {
    private final SensorService sensorService;
    private final SensorMapper sensorMapper;

    @Autowired
    public SensorController(SensorService sensorService, SensorMapper sensorMapper) {
        this.sensorService = sensorService;
        this.sensorMapper = sensorMapper;
    }

    @PostMapping
    public void create(SensorRequestDto sensorDto) {
        sensorService.save(sensorMapper.convertToEntity(sensorDto));
    }

    @PutMapping
    public void update(SensorRequestDto sensorDto) {
        sensorService.save(sensorMapper.convertToEntity(sensorDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        sensorService.delete(id);
    }

    @GetMapping
    public List<SensorResponseDto> getAll() {
        return sensorService.getAll()
                            .stream()
                            .map(sensorMapper::convertToDto)
                            .collect(Collectors.toList());
    }

    @GetMapping("/{value}")
    public List<SensorResponseDto> getAllByValue(@PathVariable String value) {
         return sensorService.getAllByValue(value)
                             .stream()
                             .map(sensorMapper::convertToDto)
                             .collect(Collectors.toList());
    }

    @GetMapping("/description/")
    public String getDescription(@RequestParam String name) {
        return sensorService.getDescription(name);
    }
}
