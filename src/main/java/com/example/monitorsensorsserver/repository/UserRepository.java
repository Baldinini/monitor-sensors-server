package com.example.monitorsensorsserver.repository;

import com.example.monitorsensorsserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
