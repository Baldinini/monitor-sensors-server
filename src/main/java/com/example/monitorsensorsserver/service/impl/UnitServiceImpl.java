package com.example.monitorsensorsserver.service.impl;

import com.example.monitorsensorsserver.entity.Unit;
import com.example.monitorsensorsserver.repository.UnitRepository;
import com.example.monitorsensorsserver.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
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
    public Unit getById(Long id) {
        Optional<Unit> unit = unitRepository.findById(id);
        if (unit.isPresent()) {
            return unit.get();
        }
        throw new NoSuchElementException("Can't get unit by this id: " + id);
    }
}
