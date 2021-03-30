package com.example.monitorsensorsserver.repository;

import com.example.monitorsensorsserver.entity.Usr;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;
    private Usr user;

    @BeforeEach
    void setUp() {
        user = new Usr();
        user.setLogin("user");
        user.setPassword("1324");
        userRepository.save(user);
    }

    @Test
    void canFindByLogin() {
        Optional<Usr> optionalUsr = userRepository.findByLogin(user.getLogin());

        assertThat(optionalUsr).isNotNull();
        assertThat(optionalUsr.get()).isEqualTo(user);
    }
}
