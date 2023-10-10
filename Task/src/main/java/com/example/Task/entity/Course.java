package com.example.Task.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "Course ID cannot be null")
    private Long course_id;

    @NotBlank(message = "Course title cannot be blank")
    @Size(min = 2, max = 20, message = "Course title must be between 2 and 20 characters")
    private String course_title;

    @Min(value = 0, message = "Fee must be a positive number or zero")
    private double course_fee;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedCourses")
    private Set<Student> students = new HashSet<>();
}
