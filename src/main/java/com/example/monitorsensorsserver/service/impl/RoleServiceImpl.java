package com.example.monitorsensorsserver.service.impl;

import com.example.monitorsensorsserver.entity.Role;
import com.example.monitorsensorsserver.repository.RoleRepository;
import com.example.monitorsensorsserver.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {

        this.roleRepository = roleRepository;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
}
