package com.example.monitorsensorsserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonitorSensorsServerApplication {


    public static void main(String[] args) {

        SpringApplication.run(MonitorSensorsServerApplication.class, args);
    }
}
