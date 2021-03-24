package com.example.monitorsensorsserver.service.impl;

import com.example.monitorsensorsserver.entity.Usr;
import com.example.monitorsensorsserver.repository.UserRepository;
import com.example.monitorsensorsserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public void save(Usr user) {
        String password = encoder.encode(user.getPassword());
        user.setPassword(password);
        userRepository.save(user);
    }

    @Override
    public Usr getByLogin(String login) {

        return userRepository.findByLogin(login).get();
    }
}
