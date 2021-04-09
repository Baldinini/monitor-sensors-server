package com.example.monitorsensorsserver.service.impl;

import com.example.monitorsensorsserver.entity.Unit;
import com.example.monitorsensorsserver.entity.UnitName;
import com.example.monitorsensorsserver.repository.UnitRepository;
import com.example.monitorsensorsserver.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UnitServiceImpl implements UnitService {
    private final UnitRepository unitRepository;

    @Autowired
    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public void save(Unit unit) {
        unitRepository.save(unit);
    }

    @Override
    public Optional<Unit> getByUnitName(String name) {

        return unitRepository.findByUnitName(UnitName.valueOf(name));
    }
}
