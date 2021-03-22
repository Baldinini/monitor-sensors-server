package com.example.monitorsensorsserver.dto.response;

import lombok.Data;

@Data
public class SensorResponseDto {
    private Long id;
    private String name;
    private String model;
    private String type;
    private String unit;
    private String location;
    private String description;
    private int rangeFrom;
    private int rangeTo;
}
