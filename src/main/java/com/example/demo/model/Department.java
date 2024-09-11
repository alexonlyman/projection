package com.example.demo.model;

import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
