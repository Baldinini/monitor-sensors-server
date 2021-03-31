package com.example.monitorsensorsserver.service.impl;

import com.example.monitorsensorsserver.entity.Usr;
import com.example.monitorsensorsserver.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private BCryptPasswordEncoder encoder;
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl(userRepository, encoder);
    }

    @Test
    void save() {
        Usr user = new Usr();
        user.setLogin("user");
        user.setPassword("1234");
        userService.save(user);
        ArgumentCaptor<Usr> argumentCaptor = ArgumentCaptor.forClass(Usr.class);
        verify(userRepository).save(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isEqualTo(user);
    }
}
