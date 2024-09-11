package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

// TODO: find out what a bean is in this context
// Annotation a class as configuration indicates that its primary purpose is defining beans
@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
        Student micla = new Student(
                "micla",
                "micla@gmail.com",
                LocalDate.of(2001,11,19)
        );

        Student damia = new Student(
                "Damia",
                "Damia@gmail.com",
                LocalDate.of(1998,10,23)
        );
        repository.saveAll(
                List.of(micla,damia)
        );
        };
    }
}
