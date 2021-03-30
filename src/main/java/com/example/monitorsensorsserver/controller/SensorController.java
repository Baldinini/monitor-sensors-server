package com.example.monitorsensorsserver.controller;

import com.example.monitorsensorsserver.dto.request.SensorRequestDto;
import com.example.monitorsensorsserver.dto.response.SensorResponseDto;
import com.example.monitorsensorsserver.entity.Sensor;
import com.example.monitorsensorsserver.mapper.SensorMapper;
import com.example.monitorsensorsserver.service.SensorService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        sensorService.save(sensorMapper.convertToEntity(sensorDto));
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody @Valid SensorRequestDto sensorDto) {

        log.warn("method: update");
        Sensor sensor = sensorMapper.convertToEntity(sensorDto);
        sensor.setId(id);
        sensorService.save(sensor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

        log.warn("method: delete");
        sensorService.delete(id);
    }

    @GetMapping
    public List<SensorResponseDto> getAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "2") Integer size) {

        log.warn("method: getAll");
        Pageable pageable = PageRequest.of(page, size);
        return sensorService.getAll(pageable).stream().map(sensorMapper::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/description")
    public String getDescription(@RequestParam String name) {

        log.warn("method: getDescription");
        return sensorService.getDescription(name);
    }
}
