package com.example.monitorsensorsserver.mapper;

public interface GenericMapperRequestToEntity<I, T> {
    T convertToEntity(I requestDto);
}
