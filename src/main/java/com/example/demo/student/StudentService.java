package com.example.demo.student;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping  // as we want something from server
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("Email Taken");
        }
        studentRepository.save(student);

        System.out.println(student.getName() + "\n" + student.getEmail() + "\n" + student.getAge());
    }


    public void deleteStudent(Long id) {
        boolean b = studentRepository.existsById(id);
        if (!b) {
            throw new IllegalStateException("Student with id " + id + " doesn't exist");
        }

        studentRepository.deleteById(id);
    }

    @Transactional // Makes entity a managed state so we don't need to write queries.
    public void updateStudent(Long id, String name, String email) {
        Student std = studentRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(
                        "student with id " + id + " doesn't exist"));

        if (name != null && name.length() != 0 && !Objects.equals(name, std.getName())) std.setName(name);
        if (email != null && email.length() != 0 && !Objects.equals(email, std.getEmail())) {
            if(studentRepository.findStudentByEmail(email).isPresent()){
                throw new IllegalStateException("Email taken");
            }
            std.setEmail(email);}
    }
}
