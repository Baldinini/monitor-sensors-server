package com.example.monitorsensorsserver.repository;

import com.example.monitorsensorsserver.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnitRepository extends JpaRepository<Unit, Long> {
    Optional<Unit> findById(Long id);
}
