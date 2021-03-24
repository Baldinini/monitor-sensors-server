package com.example.monitorsensorsserver.service.impl;

import com.example.monitorsensorsserver.entity.Usr;
import com.example.monitorsensorsserver.repository.UserRepository;
import com.example.monitorsensorsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(Usr user) {
        userRepository.save(user);
    }

    @Override
    public Usr getByLogin(String login) {

        return userRepository.findByLogin(login).get();
    }
}
