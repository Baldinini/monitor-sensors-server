package com.example.monitorsensorsserver.mapper;

import com.example.monitorsensorsserver.dto.request.SensorRequestDto;
import com.example.monitorsensorsserver.dto.response.SensorResponseDto;
import com.example.monitorsensorsserver.entity.Sensor;
import com.example.monitorsensorsserver.service.TypeService;
import com.example.monitorsensorsserver.service.UnitService;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class SensorMapper {
    private final ModelMapper mapper;
    private final TypeService typeService;
    private final UnitService unitService;

    @Autowired
    public SensorMapper(ModelMapper mapper, TypeService typeService, UnitService unitService) {
        this.mapper = mapper;
        this.typeService = typeService;
        this.unitService = unitService;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Sensor.class, SensorResponseDto.class)
                .addMappings(m -> {
                    m.skip(SensorResponseDto::setTypeName);
                    m.skip(SensorResponseDto::setUnitName);
                })
                .setPostConverter(toDtoConverter());
        mapper.createTypeMap(SensorRequestDto.class, Sensor.class)
                .addMappings(m -> {
                    m.skip(Sensor::setType);
                    m.skip(Sensor::setUnit);
                })
                .setPostConverter(toEntityConverted());
    }

    private Converter<SensorRequestDto, Sensor> toEntityConverted() {
        return context -> {
            SensorRequestDto source = context.getSource();
            Sensor destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private Converter<Sensor, SensorResponseDto> toDtoConverter() {
        return context -> {
            Sensor source = context.getSource();
            SensorResponseDto destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapSpecificFields(Sensor source, SensorResponseDto destination) {
        destination.setTypeName(source.getType().getTypeName().toString());
        destination.setUnitName(source.getUnit().getUnitName().toString());
    }

    private void mapSpecificFields(SensorRequestDto source, Sensor destination) {
        destination.setType(typeService.getByTypeName(source.getTypeName()).orElse(null));
        destination.setUnit(unitService.getByUnitName(source.getUnitName()).orElse(null));
    }

    public Sensor toEntity(SensorRequestDto dto) {
        return Objects.isNull(dto)
                ? null
                : mapper.map(dto, Sensor.class);
    }

    public SensorResponseDto toDto(Sensor entity) {
        return Objects.isNull(entity)
                ? null
                : mapper.map(entity, SensorResponseDto.class);
    }
}
