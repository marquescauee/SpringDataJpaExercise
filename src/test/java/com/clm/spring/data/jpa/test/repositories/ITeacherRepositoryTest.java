package com.clm.spring.data.jpa.test.repositories;

import com.clm.spring.data.jpa.test.models.Course;
import com.clm.spring.data.jpa.test.models.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ITeacherRepositoryTest {

    @Autowired
    private ITeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {

        Course course = Course.builder()
                .title("Software Engineering")
                .credit(12)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Jonas")
                .lastName("Santana")
                .courses(List.of(course))
                .build();

        teacherRepository.save(teacher);
    }

}