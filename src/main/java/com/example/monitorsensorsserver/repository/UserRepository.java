package com.example.monitorsensorsserver.repository;

import com.example.monitorsensorsserver.entity.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usr, Long> {

    Optional<Usr> findByLogin(String login);
}
