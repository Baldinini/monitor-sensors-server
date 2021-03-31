package com.example.monitorsensorsserver.service.impl;

import com.example.monitorsensorsserver.entity.Role;
import com.example.monitorsensorsserver.entity.RoleName;
import com.example.monitorsensorsserver.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {

    @Mock
    private RoleRepository roleRepository;
    private RoleServiceImpl roleService;

    @BeforeEach
    void setUp() {
        roleService = new RoleServiceImpl(roleRepository);
    }

    @Test
    void save() {
        Role role = new Role();
        role.setRoleName(RoleName.ADMIN);
        roleService.save(role);
        ArgumentCaptor<Role> argumentCaptor = ArgumentCaptor.forClass(Role.class);
        verify(roleRepository).save(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue()).isEqualTo(role);
    }
}
