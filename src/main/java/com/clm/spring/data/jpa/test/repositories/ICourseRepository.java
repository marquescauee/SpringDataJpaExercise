package com.clm.spring.data.jpa.test.repositories;

import com.clm.spring.data.jpa.test.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
}
