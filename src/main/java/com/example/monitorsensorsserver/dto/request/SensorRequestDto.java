package com.example.monitorsensorsserver.dto.request;

import com.example.monitorsensorsserver.entity.Type;
import com.example.monitorsensorsserver.entity.Unit;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SensorRequestDto {
    @NotNull
    @Size(max = 30)
    private String name;
    @NotNull
    @Size(max = 15)
    private String model;
    @NotNull
    private Long idType;
    @NotNull
    private Long idUnit;
    @Size(max = 40)
    private String location;
    @Size(max = 200)
    private String description;
    private int rangeFrom;
    private int rangeTo;
}
