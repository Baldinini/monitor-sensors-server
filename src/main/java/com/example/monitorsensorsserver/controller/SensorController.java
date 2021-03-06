package com.example.monitorsensorsserver.controller;

import com.example.monitorsensorsserver.dto.request.SensorRequestDto;
import com.example.monitorsensorsserver.dto.response.SensorResponseDto;
import com.example.monitorsensorsserver.entity.Sensor;
import com.example.monitorsensorsserver.mapper.SensorMapper;
import com.example.monitorsensorsserver.service.SensorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Log4j2
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
    public void create(@RequestBody @Valid SensorRequestDto sensorDto) {

        log.warn("method: create");
        sensorService.save(sensorMapper.toEntity(sensorDto));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid SensorRequestDto sensorDto) {

        log.warn("method: update");
        Sensor sensor = sensorMapper.toEntity(sensorDto);
        sensor.setId(id);
        sensorService.save(sensor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        log.warn("method: delete");
        sensorService.delete(id);
    }

    @GetMapping
    public ResponseEntity<List<SensorResponseDto>> getAll() {
        log.warn("method: getAll");
        return ResponseEntity.ok(sensorService.getAll().stream().map(sensorMapper::toDto).collect(Collectors.toList()));
    }

    @GetMapping("/description")
    public String getDescription(@RequestParam String name) {

        log.warn("method: getDescription");
        return sensorService.getDescription(name);
    }

    @GetMapping("/{id}")
    public SensorResponseDto getById(@PathVariable Long id) {
        log.warn("method: getById");
        return sensorMapper.toDto(sensorService.getById(id));
    }
}
