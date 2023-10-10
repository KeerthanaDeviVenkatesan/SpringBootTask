package com.example.Task.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teacher_id;
    @NotBlank(message = "Department name cannot be blank")
    private String teacher_name;
    @NotBlank(message = "Department name cannot be blank")
    private String teacher_dep;
}
