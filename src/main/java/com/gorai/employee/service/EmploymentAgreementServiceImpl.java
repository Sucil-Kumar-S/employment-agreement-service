package com.gorai.employee.service;

import com.gorai.employee.model.EmploymentAgreement;
import com.gorai.employee.repository.EmploymentAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Marks this class as a Spring service bean
public class EmploymentAgreementServiceImpl implements EmploymentAgreementService {

    @Autowired
    private EmploymentAgreementRepository repository;

    @Override
    public EmploymentAgreement createAgreement(EmploymentAgreement agreement) {
        return repository.save(agreement); // Save agreement to the database
    }

    @Override
    public Optional<EmploymentAgreement> getAgreementById(Long id) {
        return repository.findById(id); // Fetch agreement by ID
    }

    @Override
    public EmploymentAgreement updateAgreement(Long id, EmploymentAgreement updatedAgreement) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Agreement not found with ID: " + id);
        }
        updatedAgreement.setId(id); // Ensure the ID is set for the update
        return repository.save(updatedAgreement); // Save the updated agreement
    }

    @Override
    public void deleteAgreement(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Agreement not found with ID: " + id);
        }
        repository.deleteById(id); // Delete agreement by ID
    }

    @Override
    public List<EmploymentAgreement> getAllAgreements() {
        return repository.findAll(); // Fetch all agreements
    }

    @Override
    public List<EmploymentAgreement> findAgreementsByRole(String role) {
        return repository.findByRole(role); // Fetch agreements by role
    }

    @Override
    public List<EmploymentAgreement> searchAgreements(String role, Double salaryMin, Double salaryMax) {
        if (role != null && salaryMin != null && salaryMax != null) {
            return repository.findByRoleAndSalaryBetween(role, salaryMin, salaryMax);
        } else if (role != null) {
            return repository.findByRole(role);
        } else if (salaryMin != null && salaryMax != null) {
            return repository.findBySalaryBetween(salaryMin, salaryMax);
        } else {
            return repository.findAll();
        }
    }
}
