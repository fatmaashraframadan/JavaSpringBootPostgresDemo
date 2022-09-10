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
                    "student1",
                    "student1@gmail.com",
                    LocalDate.of(1999,  Month.JUNE ,6)
            );

            Student std2 = new Student(
                    "student2",
                    "student2@gmail.com",
                    LocalDate.of(1994, Month.JANUARY,21)
            );

            Student std3 = new Student(
                    "student3",
                    "student3@gmail.com",
                    LocalDate.of(2004, Month.AUGUST,21)
            );

            studentRepository.saveAll(
                    List.of(std1,std2)
            );
        };
    }
}
