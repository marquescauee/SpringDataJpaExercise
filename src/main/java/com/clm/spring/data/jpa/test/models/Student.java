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
@Table(name = "students", uniqueConstraints = @UniqueConstraint(name = "email", columnNames = "email"))
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long idStudent;

    private String firstName;
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Embedded
    private Guardian guardian;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "id_student", referencedColumnName = "idStudent"),
            inverseJoinColumns = @JoinColumn(name = "id_course", referencedColumnName = "idCourse")
    )
    private List<Course> courses;

    public void addCourse(Course course) {
        if(courses == null) {
            courses = new ArrayList<>();
        }

        courses.add(course);
    }


}
