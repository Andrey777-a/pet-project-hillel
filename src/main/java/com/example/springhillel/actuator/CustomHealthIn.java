package com.example.springhillel.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIn implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = 0;
        // In the above line,I am simple assigning zero,but you can call Health check related code like below commented line and that method can return the appropriate code.
        // int errorCode = performHealthCheck();
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }
}