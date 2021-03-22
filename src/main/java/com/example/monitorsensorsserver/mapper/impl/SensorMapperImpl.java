package com.example.monitorsensorsserver.mapper.impl;

import com.example.monitorsensorsserver.dto.request.SensorRequestDto;
import com.example.monitorsensorsserver.dto.response.SensorResponseDto;
import com.example.monitorsensorsserver.entity.Sensor;
import com.example.monitorsensorsserver.mapper.SensorMapper;
import org.springframework.stereotype.Component;

@Component
public class SensorMapperImpl implements SensorMapper {

    @Override
    public SensorResponseDto convertToDto(Sensor entity) {

        return null;
    }

    @Override
    public Sensor convertToEntity(SensorRequestDto requestDto) {

        return null;
    }
}
