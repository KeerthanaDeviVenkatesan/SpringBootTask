package com.example.Task.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "address_id")
    private Long add_id;
    private String add_name;
    @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Phone number must be in a valid format")
    private String add_phNo;


    @OneToOne(mappedBy = "address")
    private College college;
}

