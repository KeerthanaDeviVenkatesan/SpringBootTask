package com.example.Task.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "dep_id")
    @NotNull(message = "Department ID cannot be null")
    private Long dep_id;
    @NotBlank(message = "Department name cannot be blank")
    private String dep_name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_dep_id",referencedColumnName = "dep_id")
    private List<Teacher> teacher;

}
