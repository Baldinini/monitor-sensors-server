package com.example.monitorsensorsserver.dto.response;

import lombok.Data;

@Data
public class SensorResponseDto {
    private Long id;
    private String name;
    private String model;
    private String typeName;
    private String unitName;
    private String location;
    private String description;
    private Integer rangeFrom;
    private Integer rangeTo;
}
