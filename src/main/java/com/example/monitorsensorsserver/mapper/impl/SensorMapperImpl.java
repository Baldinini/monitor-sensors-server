package com.example.monitorsensorsserver.mapper.impl;

import com.example.monitorsensorsserver.dto.request.SensorRequestDto;
import com.example.monitorsensorsserver.dto.response.SensorResponseDto;
import com.example.monitorsensorsserver.entity.Sensor;
import com.example.monitorsensorsserver.mapper.SensorMapper;
import com.example.monitorsensorsserver.service.TypeService;
import com.example.monitorsensorsserver.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SensorMapperImpl implements SensorMapper {
    private final TypeService typeService;
    private final UnitService unitService;

    @Autowired
    public SensorMapperImpl(TypeService typeService, UnitService unitService) {
        this.typeService = typeService;
        this.unitService = unitService;
    }

    @Override
    public SensorResponseDto convertToDto(Sensor entity) {
        SensorResponseDto sensorDto = new SensorResponseDto();
        sensorDto.setName(entity.getName());
        sensorDto.setModel(entity.getModel());
        sensorDto.setUnit(entity.getUnit().getUnitName().toString());
        sensorDto.setType(entity.getType().getTypeName().toString());
        sensorDto.setDescription(entity.getDescription());
        sensorDto.setRangeFrom(entity.getRangeFrom());
        sensorDto.setRangeTo(entity.getRangeTo());
        sensorDto.setLocation(entity.getLocation());
        return sensorDto;
    }

    @Override
    public Sensor convertToEntity(SensorRequestDto requestDto) {
        Sensor sensor = new Sensor();
        sensor.setName(requestDto.getName());
        sensor.setModel(requestDto.getModel());
        sensor.setUnit(unitService.getById(requestDto.getIdUnit()));
        sensor.setType(typeService.getById(requestDto.getIdType()));
        sensor.setDescription(requestDto.getDescription());
        sensor.setRangeFrom(requestDto.getRangeFrom());
        sensor.setRangeTo(requestDto.getRangeTo());
        sensor.setLocation(requestDto.getLocation());
        return sensor;
    }
}
