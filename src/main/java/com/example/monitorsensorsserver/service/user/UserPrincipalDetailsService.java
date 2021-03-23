package com.example.monitorsensorsserver.service.user;

import com.example.monitorsensorsserver.entity.Usr;
import com.example.monitorsensorsserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public UserPrincipalDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Usr user = userRepository.findByLogin(login).get();
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
}
