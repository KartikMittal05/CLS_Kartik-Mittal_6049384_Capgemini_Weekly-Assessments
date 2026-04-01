package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Loan;
import com.example.demo.repository.LoanRepository;

import com.example.demo.exception.*;
@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository repository;

    @Override
    public Loan createLoan(Loan loan) {

        // Rule 1: amount validation
        if (loan.getLoanAmount() <= 0 || loan.getLoanAmount() > 5000000) {
            throw new InvalidLoanAmountException("Loan amount must be between 1 and 5000000");
        }

        // Rule 2: duplicate pending check
        repository.findByApplicantNameAndStatus(loan.getApplicantName(), "PENDING")
                .ifPresent(l -> {
                    throw new DuplicateLoanApplicationException(
                            "User already has a pending loan");
                });

        loan.setStatus("PENDING");

        return repository.save(loan);
    }

    @Override
    public List<Loan> getAllLoans() {
        return repository.findAll();
    }

    @Override
    public Loan getLoanById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new LoanNotFoundException("Loan not found with id: " + id));
    }

    @Override
    public Loan updateLoanStatus(Long id, String status) {

        Loan loan = getLoanById(id);

        loan.setStatus(status.toUpperCase());

        return repository.save(loan);
    }
}