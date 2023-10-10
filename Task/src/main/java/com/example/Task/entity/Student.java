package com.example.Task.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_Id")
    @NotNull(message = "Student ID cannot be null")
    private Long student_id;

    @NotBlank(message = "Student name cannot be blank")
    private String student_name;

    @NotBlank(message = "Student department cannot be blank")
    private String student_dep;


    @ManyToMany
    @JoinTable(name = "student_course",
            joinColumns=@JoinColumn(name = "student_id"),
            inverseJoinColumns=@JoinColumn(name = "course_id")
    )
    private Set<Course> assignedCourses=new HashSet<>();
}
