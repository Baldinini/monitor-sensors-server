package com.example.monitorsensorsserver.repository;

import com.example.monitorsensorsserver.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Long> {

    Optional<Type> findById(Long id);
}
