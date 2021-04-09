package com.example.monitorsensorsserver.repository;

import com.example.monitorsensorsserver.entity.Unit;
import com.example.monitorsensorsserver.entity.UnitName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

    Optional<Unit> findByUnitName(UnitName name);
}
