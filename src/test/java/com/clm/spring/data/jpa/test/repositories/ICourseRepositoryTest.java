package com.clm.spring.data.jpa.test.repositories;

import com.clm.spring.data.jpa.test.models.Course;
import com.clm.spring.data.jpa.test.models.Student;
import com.clm.spring.data.jpa.test.models.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class ICourseRepositoryTest {

    @Autowired
    private ICourseRepository courseRepository;

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Marlon")
                .lastName("Marques")
                .build();

        Course course = Course.builder()
                .title("java")
                .credit(16)
                .teacher(teacher)
                .build();

        courseRepository.save(course);

    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords = PageRequest.of(0, 3);

        Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(secondPageWithTwoRecords).getContent();

        long totalElements = courseRepository.findAll(secondPageWithTwoRecords).getTotalElements();

        long totalPages = courseRepository.findAll(secondPageWithTwoRecords).getTotalPages();

        System.out.println(totalPages);

        System.out.println(totalElements);

        System.out.println(courses);
    }

    @Test
    public void findAllSorting() {

        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("title"));

        Pageable sortByCreditDesc = PageRequest.of(0, 2, Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc = PageRequest.of(0, 2, Sort.by("title").descending().and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();

        System.out.println(courses);
    }

    @Test
    public void findByTitleContaining() {
        Pageable firstPageTenRecords = PageRequest.of(0, 10);

        List<Course> courses = courseRepository.findByTitleContaining("e", firstPageTenRecords).getContent();

        System.out.println(courses);
    }

//    @Test
//    public void saveCourseWithStudentAndTeacher() {
//        Teacher teacher = Teacher.builder()
//                .firstName("Pam")
//                .lastName("Marq")
//                .build();
//
//        Student student = Student.builder()
//                .firstName("Cauê")
//                .lastName("Lopes")
//                .email("cauezitos@hotmail.com")
//                .build();
//
//        Course course = Course.builder()
//                .title("javascript")
//                .credit(3)
//                .teacher(teacher)
//                .build();
//
//        course.addStudent(student);
//
//        courseRepository.save(course);
//    }
}