package com.example.monitorsensorsserver.service;

import com.example.monitorsensorsserver.entity.Type;

public interface TypeService {
    void save(Type type);

    Type getById(Long id);
}
