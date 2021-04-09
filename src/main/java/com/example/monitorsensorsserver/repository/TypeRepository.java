package com.example.monitorsensorsserver.repository;

import com.example.monitorsensorsserver.entity.Type;
import com.example.monitorsensorsserver.entity.TypeName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {

    Optional<Type> findByTypeName(TypeName name);
}
