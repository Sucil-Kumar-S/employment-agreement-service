package com.gorai.employee.controller;

import com.gorai.employee.model.EmploymentAgreement;
import com.gorai.employee.service.EmploymentAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marks this as a REST controller
@RequestMapping("/api/employment-agreements") // Base URL for this controller
public class EmploymentAgreementController {

    @Autowired
    private EmploymentAgreementService service;

    @PostMapping
    public ResponseEntity<EmploymentAgreement> createAgreement(@RequestBody EmploymentAgreement agreement) {
        return ResponseEntity.ok(service.createAgreement(agreement));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmploymentAgreement> getAgreement(@PathVariable Long id) {
        return service.getAgreementById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmploymentAgreement> updateAgreement(
            @PathVariable Long id, @RequestBody EmploymentAgreement agreement) {
        return ResponseEntity.ok(service.updateAgreement(id, agreement));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgreement(@PathVariable Long id) {
        service.deleteAgreement(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EmploymentAgreement>> getAllAgreements() {
        return ResponseEntity.ok(service.getAllAgreements());
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<EmploymentAgreement>> getAgreementsByRole(@PathVariable String role) {
        return ResponseEntity.ok(service.findAgreementsByRole(role));
    }

    @GetMapping("/search")
    public ResponseEntity<List<EmploymentAgreement>> searchAgreements(
        @RequestParam(required = false) String role,
        @RequestParam(required = false) Double salaryMin,
        @RequestParam(required = false) Double salaryMax) {
        return ResponseEntity.ok(service.searchAgreements(role, salaryMin, salaryMax));
    }
}
