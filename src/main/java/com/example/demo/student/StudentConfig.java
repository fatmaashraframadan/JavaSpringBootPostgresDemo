package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Calendar.JANUARY;
import static java.util.Calendar.JUNE;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository){
        return args->{
           Student std1 = new Student(
                    "Fatma",
                    "fatma@gmail.com",
                    LocalDate.of(1999,  Month.JUNE ,6)
            );

            Student std2 = new Student(
                    "Sarah",
                    "Saraah@gmail.com",
                    LocalDate.of(2000, Month.JANUARY,21)
            );

            studentRepository.saveAll(
                    List.of(std1,std2)
            );
        };
    }
}
