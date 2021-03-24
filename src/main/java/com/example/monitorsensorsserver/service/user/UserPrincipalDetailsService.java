package com.example.monitorsensorsserver.service.user;

import com.example.monitorsensorsserver.entity.Usr;
import com.example.monitorsensorsserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserPrincipalDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        Optional<Usr> user = userRepository.findByLogin(login);
        if (user.isPresent()) {
            return user.map(UserPrincipal::new).get();
        }
        throw new UsernameNotFoundException("Can't find user by this login: " + login);
    }
}
