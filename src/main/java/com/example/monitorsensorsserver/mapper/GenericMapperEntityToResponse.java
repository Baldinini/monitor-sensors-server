package com.example.monitorsensorsserver.mapper;

public interface GenericMapperEntityToResponse <I, T> {
    T convertToDto(I entity);
}
