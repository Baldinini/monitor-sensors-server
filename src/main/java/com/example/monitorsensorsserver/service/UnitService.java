package com.example.monitorsensorsserver.service;

import com.example.monitorsensorsserver.entity.Unit;

public interface UnitService {
    void save(Unit unit);

    Unit getById(Long id);
}
