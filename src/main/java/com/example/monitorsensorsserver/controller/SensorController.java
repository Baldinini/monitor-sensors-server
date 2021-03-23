package com.example.monitorsensorsserver.controller;

import com.example.monitorsensorsserver.dto.request.SensorRequestDto;
import com.example.monitorsensorsserver.dto.response.SensorResponseDto;
import com.example.monitorsensorsserver.mapper.SensorMapper;
import com.example.monitorsensorsserver.service.SensorService;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Log4j2
@RequestMapping("/sensors")
public class SensorController {

    private final SensorService sensorService;
    private final SensorMapper sensorMapper;
    private final ModelMapper modelMapper;

    @Autowired
    public SensorController(SensorService sensorService, SensorMapper sensorMapper, ModelMapper modelMapper) {

        this.sensorService = sensorService;
        this.sensorMapper = sensorMapper;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void create(SensorRequestDto sensorDto) {

        log.warn("method: create");
        sensorService.save(sensorMapper.convertToEntity(sensorDto));
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void update(SensorRequestDto sensorDto) {

        log.warn("method: update");
        sensorService.save(sensorMapper.convertToEntity(sensorDto));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void delete(@PathVariable Long id) {

        log.warn("method: delete");
        sensorService.delete(id);
    }

    @GetMapping
    public List<SensorResponseDto> getAll() {

        log.warn("method: getAll");
        return sensorService.getAll().stream().map(sensorMapper::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{value}")
    public List<SensorResponseDto> getAllByValue(@PathVariable String value) {

        log.warn("method: getAllByValue");
        return sensorService.getAllByValue(value).stream().map(sensorMapper::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/description/")
    public String getDescription(@RequestParam String name) {

        log.warn("method: getDescription");
        return sensorService.getDescription(name);
    }
}
