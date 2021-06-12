package com.example.demo.studentDEMO;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student mariachi = new Student(
                    1,
                    "mariachi",
                    "mariiii@gmailo.com",
                    LocalDate.of(2003, OCTOBER, 22)
            );
            Student alex = new Student(
                    "alex",
                    "ale@gmailo.com",
                    LocalDate.of(2012, OCTOBER, 22)
            );

            studentRepository.saveAll(List.of(mariachi, alex));
        };
    }
}
