package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    Optional<Loan> findByApplicantNameAndStatus(String applicantName, String status);
}