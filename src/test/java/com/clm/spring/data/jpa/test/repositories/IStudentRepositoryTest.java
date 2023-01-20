package com.clm.spring.data.jpa.test.repositories;

import com.clm.spring.data.jpa.test.models.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IStudentRepositoryTest {

    @Autowired
    private IStudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .email("caue@gmail.com")
                .firstName("Cauê")
                .lastName("Marques")
                .guardianName("Ana")
                .guardianEmail("ana@gmail.com")
                .guardianMobile("123729132983")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> students = studentRepository.findAll();

        System.out.println(students);
    }

}