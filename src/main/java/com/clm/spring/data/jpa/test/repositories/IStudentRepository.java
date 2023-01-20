package com.clm.spring.data.jpa.test.repositories;

import com.clm.spring.data.jpa.test.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    @Query(
            value = "SELECT * FROM student s where s.email = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddress(String email);

    @Query(
            value = "SELECT * FROM student s WHERE s.email = :email AND s.first_name = :firstName",
            nativeQuery = true
    )
    Student getStudentByInfoNativeNamedParam(@Param("email") String email, @Param("firstName") String firstName);


    @Modifying
    @Transactional
    @Query(
            value = "UPDATE student SET first_name = :firstName WHERE email = :email",
            nativeQuery = true
    )
    int updateStudentNameByEmail(@Param("firstName") String firstName, @Param("email") String email);

}
