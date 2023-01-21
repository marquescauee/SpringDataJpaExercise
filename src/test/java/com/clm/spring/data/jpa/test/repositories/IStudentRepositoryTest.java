package com.clm.spring.data.jpa.test.repositories;

import com.clm.spring.data.jpa.test.models.Course;
import com.clm.spring.data.jpa.test.models.Guardian;
import com.clm.spring.data.jpa.test.models.Student;
import com.clm.spring.data.jpa.test.models.Teacher;
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
                //.guardianName("Ana")
                //.guardianEmail("ana@gmail.com")
                //.guardianMobile("123729132983")
                .build();

        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("Ana")
                .email("ana@gmail.com")
                .mobile("123729132983")
                .build();

        Student student = Student.builder()
                .firstName("Jonas")
                .email("Jonas@gmail.com")
                .lastName("Silva")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> students = studentRepository.findAll();

        System.out.println(students);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName(("Cauê"));

        System.out.println(students);
    }

    @Test
    public void getStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("caue@gmail.com");

        System.out.println(student);
    }

    @Test
    public void getStudentByInfoNativeNamedParam() {
        Student student = studentRepository.getStudentByInfoNativeNamedParam("caue@gmail.com", "Cauê");

        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEmail() {
        studentRepository.updateStudentNameByEmail("Lucas", "caue@gmail.com");
    }

    @Test
    public void saveStudentWithCourseAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Pam")
                .lastName("Marq")
                .build();

        Student student = Student.builder()
                .firstName("Cauê")
                .lastName("Lopes")
                .email("cauezitos@hotmail.com")
                .build();

        Course course = Course.builder()
                .title("javascript")
                .credit(3)
                .teacher(teacher)
                .build();

        student.addCourse(course);

        studentRepository.save(student);
    }
}