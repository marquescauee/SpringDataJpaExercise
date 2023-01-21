package com.clm.spring.data.jpa.test.repositories;

import com.clm.spring.data.jpa.test.models.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {
}
