package com.example.monitorsensorsserver.service;

import com.example.monitorsensorsserver.entity.Unit;

import java.util.Optional;

public interface UnitService {
    void save(Unit unit);

    Optional<Unit> getByUnitName(String name);
}
