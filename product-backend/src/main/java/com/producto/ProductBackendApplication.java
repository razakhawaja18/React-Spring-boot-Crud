package com.producto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProductBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductBackendApplication.class, args);
    }
}