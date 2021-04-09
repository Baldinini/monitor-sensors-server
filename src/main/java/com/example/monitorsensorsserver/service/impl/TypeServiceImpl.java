package com.example.monitorsensorsserver.service.impl;

import com.example.monitorsensorsserver.entity.Type;
import com.example.monitorsensorsserver.entity.TypeName;
import com.example.monitorsensorsserver.repository.TypeRepository;
import com.example.monitorsensorsserver.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeServiceImpl implements TypeService {
    private final TypeRepository typeRepository;

    @Autowired
    public TypeServiceImpl(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    @Override
    public void save(Type type) {
        typeRepository.save(type);
    }

    @Override
    public Optional<Type> getByTypeName(String name) {

        return typeRepository.findByTypeName(TypeName.valueOf(name));
    }
}
