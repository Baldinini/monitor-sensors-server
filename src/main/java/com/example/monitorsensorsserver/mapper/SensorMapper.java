package com.example.monitorsensorsserver.mapper;

import com.example.monitorsensorsserver.dto.request.SensorRequestDto;
import com.example.monitorsensorsserver.dto.response.SensorResponseDto;
import com.example.monitorsensorsserver.entity.Sensor;

public interface SensorMapper extends GenericMapperEntityToResponse<Sensor, SensorResponseDto>, GenericMapperRequestToEntity<SensorRequestDto, Sensor> {

}
