package com.gorai.employee.repository;

import com.gorai.employee.model.EmploymentAgreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Indicates that this is a repository bean
public interface EmploymentAgreementRepository extends JpaRepository<EmploymentAgreement, Long> {
    // Custom query methods can be added here if needed

    // Example: Find all agreements by role
    List<EmploymentAgreement> findByRole(String role);

    // Example: Find all agreements with salary greater than a specific value
    List<EmploymentAgreement> findBySalaryGreaterThan(Double salary);
}

