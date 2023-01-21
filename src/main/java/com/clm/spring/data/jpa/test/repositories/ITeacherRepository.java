package com.clm.spring.data.jpa.test.repositories;

import com.clm.spring.data.jpa.test.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Long> {
}
