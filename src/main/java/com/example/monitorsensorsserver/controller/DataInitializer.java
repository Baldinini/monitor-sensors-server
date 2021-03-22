package com.example.monitorsensorsserver.controller;

import com.example.monitorsensorsserver.entity.Type;
import com.example.monitorsensorsserver.entity.Unit;
import com.example.monitorsensorsserver.service.TypeService;
import com.example.monitorsensorsserver.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final TypeService typeService;
    private final UnitService unitService;

    @Autowired
    public DataInitializer(TypeService typeService, UnitService unitService) {
        this.typeService = typeService;
        this.unitService = unitService;
    }

    @PostConstruct
    public void addTypeAndUnit() {
        Type pressure = new Type();
        pressure.setTypeName(Type.TypeName.PRESSURE);
        typeService.save(pressure);
        Type voltage = new Type();
        voltage.setTypeName(Type.TypeName.VOLTAGE);
        typeService.save(voltage);
        Type temperature = new Type();
        temperature.setTypeName(Type.TypeName.TEMPERATURE);
        typeService.save(temperature);
        Type humidity = new Type();
        humidity.setTypeName(Type.TypeName.HUMIDITY);
        typeService.save(humidity);

        Unit bar = new Unit();
        bar.setUnitName(Unit.UnitName.BAR);
        unitService.save(bar);
        Unit voltageUnit = new Unit();
        voltageUnit.setUnitName(Unit.UnitName.VOLTAGE);
        unitService.save(voltageUnit);
        Unit celsius = new Unit();
        celsius.setUnitName(Unit.UnitName.CELSIUS);
        unitService.save(celsius);
        Unit percent = new Unit();
        percent.setUnitName(Unit.UnitName.PERCENT);
        unitService.save(percent);
    }
}
