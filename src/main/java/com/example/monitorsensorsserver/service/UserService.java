package com.example.monitorsensorsserver.service;

import com.example.monitorsensorsserver.entity.Usr;

public interface UserService {
    void save(Usr user);

    Usr getByLogin(String login);

}
