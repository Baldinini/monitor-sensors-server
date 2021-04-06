package com.example.monitorsensorsserver.service;

import com.example.monitorsensorsserver.entity.Type;

import java.util.Optional;

public interface TypeService {
    void save(Type type);

    Optional<Type> getById(Long id);
}
