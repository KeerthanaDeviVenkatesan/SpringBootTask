package com.example.Task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "college")
public class College {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long college_id;
    private String college_name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_add_id")
    private Address address;
}
