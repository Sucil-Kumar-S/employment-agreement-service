package com.gorai.employee.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data // Generates boilerplate code like getters, setters, equals, and hashCode
@Entity // Marks this class as a JPA entity, mapping it to a database table
@Table(name = "EMPLOYMENT_AGREEMENT")
public class EmploymentAgreement {

    @Id // Specifies the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate IDs
    private Long id;

    @Column(nullable = false) // Employee name cannot be null
    private String employeeName;

    @Column(nullable = false) // Role cannot be null
    private String role;

    @Column(nullable = false) // Start date cannot be null
    private LocalDate startDate;

    @Column(nullable = false) // End date cannot be null
    private LocalDate endDate;

    @Column(nullable = false) // Salary cannot be null
    private Double salary;

    private String terms; // General contractual terms

    @ElementCollection // Maps a collection of values to a separate table
    private Map<String, String> otherDetails; // Additional details like department or manager
}
