package com.clm.spring.data.jpa.test.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "courses")
public class Course {

    @Id
    @SequenceGenerator(name = "course_sequence", sequenceName = "course_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long idCourse;

    private String title;
    private Integer credit;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_teacher", referencedColumnName = "idTeacher")
    private Teacher teacher;



}
