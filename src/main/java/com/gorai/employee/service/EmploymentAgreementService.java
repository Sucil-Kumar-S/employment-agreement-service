package com.gorai.employee.service;

import com.gorai.employee.model.EmploymentAgreement;

import java.util.List;
import java.util.Optional;

public interface EmploymentAgreementService {
    EmploymentAgreement createAgreement(EmploymentAgreement agreement);
    Optional<EmploymentAgreement> getAgreementById(Long id);
    EmploymentAgreement updateAgreement(Long id, EmploymentAgreement agreement);
    void deleteAgreement(Long id);
    List<EmploymentAgreement> getAllAgreements();
    List<EmploymentAgreement> findAgreementsByRole(String role); // Example of custom method
    List<EmploymentAgreement> searchAgreements(String role, Double salaryMin, Double salaryMax);
}

