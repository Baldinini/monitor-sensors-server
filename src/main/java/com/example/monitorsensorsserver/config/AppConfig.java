package com.example.monitorsensorsserver.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.modelmapper.config.Configuration.AccessLevel.PRIVATE;
import static org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance;

@Configuration
public class AppConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return getInstance();
    }

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
              .setMatchingStrategy(MatchingStrategies.STRICT)
              .setFieldMatchingEnabled(true)
              .setSkipNullEnabled(true)
              .setFieldAccessLevel(PRIVATE);
        return mapper;
    }

}
