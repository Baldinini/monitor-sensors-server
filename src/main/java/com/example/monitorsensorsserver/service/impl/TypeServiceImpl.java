package com.example.monitorsensorsserver.service.impl;

import com.example.monitorsensorsserver.entity.Type;
import com.example.monitorsensorsserver.repository.TypeRepository;
import com.example.monitorsensorsserver.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
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
    public Type getById(Long id) {
        Optional<Type> type = typeRepository.findById(id);
        if (type.isPresent()) {
            return type.get();
        }
        throw new NoSuchElementException("Can't get type by this id: " + id);
    }
}
