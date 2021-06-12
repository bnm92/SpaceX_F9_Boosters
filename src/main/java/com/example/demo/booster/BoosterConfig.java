package com.example.demo.booster;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class BoosterConfig {

    @Bean
    CommandLineRunner commandLineRunner(BoosterRepository boosterRepository) {
        return args -> {
            Booster boosterDemo = new Booster(
                    "BXXX",
                    true,
                    LocalDate.now(),
                    LocalDate.now(),
                    1
            );
            boosterRepository.saveAll(List.of(boosterDemo));
        };
    }
}
