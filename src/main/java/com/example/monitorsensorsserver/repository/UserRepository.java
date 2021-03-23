package com.example.monitorsensorsserver.repository;

import com.example.monitorsensorsserver.entity.Usr;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Usr, Long> {

    Optional<Usr> findByLogin(String login);
}
