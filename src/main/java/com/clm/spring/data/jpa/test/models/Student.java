package com.clm.spring.data.jpa.test.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(uniqueConstraints = @UniqueConstraint(name = "email", columnNames = "email"))
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence", sequenceName = "student_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long idStudent;

    private String firstName;
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    private String guardianName;
    private String guardianEmail;
    private String guardianMobile;
}
