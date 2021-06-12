package com.example.demo.booster;

import com.example.demo.studentDEMO.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class BoosterConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Booster boosterDemo = new Booster(
                    "BXXX",
                    true,
                    LocalDate.now(),
                    LocalDate.now(),
                    1
            );
        };
    }
}
